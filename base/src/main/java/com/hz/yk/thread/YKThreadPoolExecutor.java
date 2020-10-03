package com.hz.yk.thread;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 从 {@link ThreadPoolExecutor} 拷贝过来，便于分析调试
 * Created by wuzheng.yk on 2017/7/27.
 */
public class YKThreadPoolExecutor extends AbstractExecutorService {

    /*
     * 状态和线程数，前3位表示状态，所有线程数占29位
     */
    // 初始化状态和数量，状态为RUNNING，线程数为0
    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    /**
     * 32-3 = 29 ，低位29位存储线程池中线程数
     */
    private static final int COUNT_BITS = Integer.SIZE - 3;
    /**
     * 根据上面ctl的设计就限制了线程池最大的上限
     * 线程池最多可以有536870911个线程，一般绝对创建不到这么大
     */
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits

    /*
     *RUNNING -> SHUTDOWN：手动调用shutdown方法，或者ThreadPoolExecutor要被GC回收的时候调用finalize方法，finalize方法内部也会调用shutdown方法
     *
     *(RUNNING or SHUTDOWN) -> STOP：调用shutdownNow方法
     *
     *SHUTDOWN -> TIDYING：当队列和线程池都为空的时候
     *
     *STOP -> TIDYING：当线程池为空的时候
     *
     *TIDYING -> TERMINATED：terminated方法调用完成之后
     *只有RUNNING状态下才会接收新任务；
     *只有RUNNING状态和SHUTDOWN状态才会执行任务队列中的任务；
     *其它状态都不会接收新任务，不会执行任务队列中的任务；
     */
    /**
     * 可以接受新的任务，也可以处理阻塞队列里的任务
     * -1的二进制为32个1，移位后为：11100000000000000000000000000000
     */
    private static final int RUNNING = -1 << COUNT_BITS;
    /**
     * 不接受新的任务，但是可以处理阻塞队列里的任务
     * 0的二进制为32个0，移位后还是全0
     */
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    /**
     * 不接受新的任务，不处理阻塞队列里的任务，中断正在处理的任务
     * 1的二进制为前面31个0，最后一个1，移位后为：00100000000000000000000000000000
     */
    private static final int STOP = 1 << COUNT_BITS;
    /**
     * 过渡状态，也就是说所有的任务都执行完了，当前线程池已经没有有效的线程，workerCount 的值为0，这个时候线程池的状态将会TIDYING，并且将要调用terminated方法
     * 2的二进制为01000000000000000000000000000000
     */
    private static final int TIDYING = 2 << COUNT_BITS;
    /**
     * 终止状态。terminated方法调用完成以后的状态,terminated()方法执行结束.
     * 3移位后01100000000000000000000000000000
     */
    private static final int TERMINATED = 3 << COUNT_BITS;

    // Packing and unpacking ctl

    /**
     * 得到状态，CAPACITY的非操作得到的二进制位11100000000000000000000000000000，然后做在一个与操作，相当于直接取前3位的的值
     *
     * @param c
     * @return
     */
    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    /**
     * 得到线程数，也就是后29位的数字。 直接跟CAPACITY做一个与操作即可，CAPACITY就是的值就 1 << 29 - 1 = 00011111111111111111111111111111。
     * 与操作的话前面3位肯定为0，相当于直接取后29位的值
     *
     * @param c
     * @return
     */
    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    /**
     * 设置ctl的值，rs为线程池状态，wc为线程数；
     *
     * @param rs
     * @param wc
     * @return
     */
    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    /*
     * Bit field accessors that don't require unpacking ctl.
     * These depend on the bit layout and on workerCount being never negative.
     */

    private static boolean runStateLessThan(int c, int s) {
        return c < s;
    }

    private static boolean runStateAtLeast(int c, int s) {
        return c >= s;
    }

    private static boolean isRunning(int c) {
        return c < SHUTDOWN;
    }

    /**
     * Attempts to CAS-increment the workerCount field of ctl.
     */
    private boolean compareAndIncrementWorkerCount(int expect) {
        return ctl.compareAndSet(expect, expect + 1);
    }

    /**
     * Attempts to CAS-decrement the workerCount field of ctl.
     */
    private boolean compareAndDecrementWorkerCount(int expect) {
        return ctl.compareAndSet(expect, expect - 1);
    }

    /**
     * Decrements the workerCount field of ctl. This is called only on
     * abrupt termination of a thread (see processWorkerExit). Other
     * decrements are performed within getTask.
     */
    private void decrementWorkerCount() {
        do {
        } while (!compareAndDecrementWorkerCount(ctl.get()));
    }

    /**
     * The queue used for holding tasks and handing off to worker
     * threads.  We do not require that workQueue.poll() returning
     * null necessarily means that workQueue.isEmpty(), so rely
     * solely on isEmpty to see if the queue is empty (which we must
     * do for example when deciding whether to transition from
     * SHUTDOWN to TIDYING).  This accommodates special-purpose
     * queues such as DelayQueues for which poll() is allowed to
     * return null even if it may later return non-null when delays
     * expire.
     */
    private final BlockingQueue<Runnable> workQueue;

    /**
     * Lock held on access to workers set and related bookkeeping.
     * While we could use a concurrent set of some sort, it turns out
     * to be generally preferable to use a lock. Among the reasons is
     * that this serializes interruptIdleWorkers, which avoids
     * unnecessary interrupt storms, especially during shutdown.
     * Otherwise exiting threads would concurrently interrupt those
     * that have not yet interrupted. It also simplifies some of the
     * associated statistics bookkeeping of largestPoolSize etc. We
     * also hold mainLock on shutdown and shutdownNow, for the sake of
     * ensuring workers set is stable while separately checking
     * permission to interrupt and actually interrupting.
     */
    private final ReentrantLock mainLock = new ReentrantLock();

    /**
     * Set containing all worker threads in pool. Accessed only when
     * holding mainLock.
     * 用来存储线程池中的线程，线程都被封装成了Worker对象
     */
    private final HashSet<Worker> workers = new HashSet<Worker>();

    /**
     * Wait condition to support awaitTermination
     */
    private final Condition termination = mainLock.newCondition();

    /**
     * Tracks largest attained pool size. Accessed only under
     * mainLock.
     */
    private int largestPoolSize;

    /**
     * Counter for completed tasks. Updated only on termination of
     * worker threads. Accessed only under mainLock.
     * 记录了已经销毁的线程，完成的任务总数；
     */
    private long completedTaskCount;

    /*
     * All user control parameters are declared as volatiles so that
     * ongoing actions are based on freshest values, but without need
     * for locking, since no internal invariants depend on them
     * changing synchronously with respect to other actions.
     */

    /**
     * Factory for new threads. All threads are created using this
     * factory (via method addWorker).  All callers must be prepared
     * for addWorker to fail, which may reflect a system or user's
     * policy limiting the number of threads.  Even though it is not
     * treated as an error, failure to create threads may result in
     * new tasks being rejected or existing ones remaining stuck in
     * the queue.
     * We go further and preserve pool invariants even in the face of
     * errors such as OutOfMemoryError, that might be thrown while
     * trying to create threads.  Such errors are rather common due to
     * the need to allocate a native stack in Thread.start, and users
     * will want to perform clean pool shutdown to clean up.  There
     * will likely be enough memory available for the cleanup code to
     * complete without encountering yet another OutOfMemoryError.
     */
    private volatile ThreadFactory threadFactory;

    /**
     * Handler called when saturated or shutdown in execute.
     */
    private volatile YKRejectedExecutionHandler handler;

    /**
     * Timeout in nanoseconds for idle threads waiting for work.
     * Threads use this timeout when there are more than corePoolSize
     * present or if allowCoreThreadTimeOut. Otherwise they wait
     * forever for new work.
     */
    private volatile long keepAliveTime;

    /**
     * If false (default), core threads stay alive even when idle.
     * If true, core threads use keepAliveTime to time out waiting
     * for work.
     */
    private volatile boolean allowCoreThreadTimeOut;

    /**
     * Core pool size is the minimum number of workers to keep alive
     * (and not allow to time out etc) unless allowCoreThreadTimeOut
     * is set, in which case the minimum is zero.
     */
    private volatile int corePoolSize;

    /**
     * Maximum pool size. Note that the actual maximum is internally
     * bounded by CAPACITY.
     */
    private volatile int maximumPoolSize;

    /**
     * The default rejected execution handler
     */
    private static final YKRejectedExecutionHandler defaultHandler = new YKThreadPoolExecutor.AbortPolicy();

    /**
     * Permission required for callers of shutdown and shutdownNow.
     * We additionally require (see checkShutdownAccess) that callers
     * have permission to actually interrupt threads in the worker set
     * (as governed by Thread.interrupt, which relies on
     * ThreadGroup.checkAccess, which in turn relies on
     * SecurityManager.checkAccess). Shutdowns are attempted only if
     * these checks pass.
     * All actual invocations of Thread.interrupt (see
     * interruptIdleWorkers and interruptWorkers) ignore
     * SecurityExceptions, meaning that the attempted interrupts
     * silently fail. In the case of shutdown, they should not fail
     * unless the SecurityManager has inconsistent policies, sometimes
     * allowing access to a thread and sometimes not. In such cases,
     * failure to actually interrupt threads may disable or delay full
     * termination. Other uses of interruptIdleWorkers are advisory,
     * and failure to actually interrupt will merely delay response to
     * configuration changes so is not handled exceptionally.
     */
    private static final RuntimePermission shutdownPerm = new RuntimePermission("modifyThread");

    /**
     * Class Worker mainly maintains interrupt control state for
     * threads running tasks, along with other minor bookkeeping.
     * This class opportunistically extends AbstractQueuedSynchronizer
     * to simplify acquiring and releasing a lock surrounding each
     * task execution.  This protects against interrupts that are
     * intended to wake up a worker thread waiting for a task from
     * instead interrupting a task being run.  We implement a simple
     * non-reentrant mutual exclusion lock rather than use
     * ReentrantLock because we do not want worker tasks to be able to
     * reacquire the lock when they invoke pool control methods like
     * setCorePoolSize.  Additionally, to suppress interrupts until
     * the thread actually starts running tasks, we initialize lock
     * state to a negative value, and clear it upon start (in
     * runWorker).
     */
    private final class Worker extends AbstractQueuedSynchronizer implements Runnable {

        /**
         * This class will never be serialized, but we provide a
         * serialVersionUID to suppress a javac warning.
         */
        private static final long serialVersionUID = 6138294804551838833L;

        /**
         * Thread this worker is running in.  Null if factory fails.
         */
        final Thread thread;
        /**
         * Initial task to run.  Possibly null.
         */
        Runnable firstTask;
        /**
         * Per-thread task counter
         */
        volatile long completedTasks;

        /**
         * 使用ThreadFactory构造Thread，这个构造的Thread内部的Runnable就是本身，也就是Worker。所以得到Worker的thread并start的时候，
         * 会执行Worker的run方法，也就是执行ThreadPoolExecutor的runWorker方法
         * Creates with given first task and thread from ThreadFactory.
         *
         * @param firstTask the first task (null if none)
         */
        Worker(Runnable firstTask) {

            /*
            把状态位设置成-1，这样任何线程都不能得到Worker的锁，除非调用了unlock方法。这个unlock方法会在 runWorker 方法中一开始就调用，
            这是为了确保Worker构造出来之后，没有任何线程能够得到它的锁，除非调用了runWorker之后，其他线程才能获得Worker的锁
             */
            setState(-1); // inhibit interrupts until runWorker
            this.firstTask = firstTask;
            this.thread = getThreadFactory().newThread(this);
        }

        /**
         * Delegates main run loop to outer runWorker
         */
        @Override
        public void run() {
            runWorker(this);
        }

        // Lock methods
        //
        // The value 0 represents the unlocked state.
        // The value 1 represents the locked state.

        @Override
        protected boolean isHeldExclusively() {
            return getState() != 0;
        }

        //尝试加锁方法，将状态从0设置为1；如果不是0则加锁失败,在worker线程没有启动前是-1状态，无法加锁
        //该方法重写了父类AQS的同名方法
        @Override
        protected boolean tryAcquire(int unused) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        //尝试释放锁的方法，直接将state置为0
        //该方法重写了父类AQS的同名方法
        @Override
        protected boolean tryRelease(int unused) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        //注意：tryAcquire与tryRelease是重写了AQS父类的方法，且不可以直接调用，它们被以下方法调用实现加锁解锁操作
        //加锁:acquire法是它父类AQS类的方法,会调用tryAcquire方法加锁
        public void lock() {
            acquire(1);
        }

        public boolean tryLock() {
            return tryAcquire(1);
        }

        //解锁:release方法是它父类AQS类的方法，会调用tryRelease方法
        public void unlock() {
            release(1);
        }

        public boolean isLocked() {
            return isHeldExclusively();
        }

        void interruptIfStarted() {
            Thread t;
            // Worker无论是否被持有锁，只要还没被中断，那就中断Worker
            if (getState() >= 0 && (t = thread) != null && !t.isInterrupted()) {
                try {
                    t.interrupt();
                } catch (SecurityException ignore) {
                }
            }
        }
    }

    /*
     * Methods for setting control state
     */

    /**
     * Transitions runState to given target, or leaves it alone if
     * already at least the given target.
     *
     * @param targetState the desired state, either SHUTDOWN or STOP
     *                    (but not TIDYING or TERMINATED -- use tryTerminate for that)
     */
    private void advanceRunState(int targetState) {
        for (; ; ) {
            int c = ctl.get();
            if (runStateAtLeast(c, targetState) || ctl.compareAndSet(c, ctlOf(targetState, workerCountOf(c)))) {
                break;
            }
        }
    }

    /**
     * 尝试结束线程池
     * Transitions to TERMINATED state if either (SHUTDOWN and pool
     * and queue empty) or (STOP and pool empty).  If otherwise
     * eligible to terminate but workerCount is nonzero, interrupts an
     * idle worker to ensure that shutdown signals propagate. This
     * method must be called following any action that might make
     * termination possible -- reducing worker count or removing tasks
     * from the queue during shutdown. The method is non-private to
     * allow access from ScheduledThreadPoolExecutor.
     */
    //该方法会在很多地方调用，如添加worker线程失败的addWorkerFailed（)方法，worker线程跳出执行任务的while 循环退出时的processWorkerExit（）方法，
    // 关闭线程池的shutdown()和shutdownNow()方法，从任务队列移除任务的remove()方法；
    //该方法的作用是检测当前线程池的状态是否可以将线程池终止，如果可以终止则尝试着去终止线程，否则直接返回；
    /*

     */
    final void tryTerminate() {
        for (; ; ) {
            int c = ctl.get();
            //以下状态不可被终止：
            //1.如果线程池的状态是RUNNING（不可终止）
            //或者是TIDYING（该状态一定执行过了tryTerminate方法，正在执行或即将执行terminated()方法，所以不需要重复执行），
            //或者是TERMINATED（该状态已经执行完成terminated()钩子方法，已经是被终止状态了），
            //以上三种状态直接返回。
            //2.如果线程池状态是SHUTDOWN，而且任务队列不是空的（该状态需要继续处理任务队列中的任务，不可被终止），也直接返回。
            if (isRunning(c) || runStateAtLeast(c, TIDYING) || (runStateOf(c) == SHUTDOWN && !workQueue.isEmpty())) {
                return;
            }
            //以下状态才会继续执行：
            //1.如果线程池状态是SHUTDOWN，而且任务队列是空的（shutdown状态下，任务队列为空，可以被终止），向下进行。
            //2.如果线程池状态是STOP（该状态下，不接收新任务，不执行任务队列中的任务，并中断正在执行中的线程，可以被终止），向下进行。

            // workerCount不为0则还不能停止线程池,而且这时线程都处于空闲等待的状态
            // 需要中断让线程“醒”过来，醒过来的线程才能继续处理shutdown的信号。
            if (workerCountOf(c) != 0) { // Eligible to terminate
                // 由于线程池不运行了，调用了线程池的关闭方法，在解释线程池的关闭原理的时候会说道这个方法
                // runWoker方法中w.unlock就是为了可以被中断,getTask方法也处理了中断。
                // ONLY_ONE:这里只需要中断1个线程去处理shutdown信号就可以了。
                interruptIdleWorkers(ONLY_ONE);
                return;
            }
            // 走到这里说明worker已经全部回收了，并且线程池已经不在运行，阻塞队列已经没有任务。可以准备结束线程池了
            //满足以下两个条件才会继续执行
            //1.线程池状态是STOP且 工作线程池中的线程wc是0
            //2.线程池状态是SHUTDOWN而且工作线程池wc(pool)和任务队列(queue)都是空的
            final ReentrantLock mainLock = this.mainLock;
            mainLock.lock();
            try {
                //进入TIDYING状态，线程池的状态被原子操作ctl.compareAndSet(c, ctlOf(TIDYING, 0)将状态设置为TIDYING，
                // (因为tryTerminate方法会在多处调用，存在竞争)
                if (ctl.compareAndSet(c, ctlOf(TIDYING, 0))) {
                    try {
                        terminated();
                    } finally {
                        //进入TERMINATED状态
                        //进一步在terminated结束之后的finally块中通过ctl.set(ctlOf(TERMINATED, 0))设置为TERMINATED。
                        // terminated方法调用完毕之后，状态变为TERMINATED
                        ctl.set(ctlOf(TERMINATED, 0));
                        //最后执行termination.signalAll()，会唤醒awaitTermination方法中由于执行termination.awaitNanos(nanos)操作进入等待状态的线程
                        termination.signalAll();
                    }
                    return;
                }
            } finally {
                mainLock.unlock();
            }
            // else retry on failed CAS
        }
    }

    /*
     * Methods for controlling interrupts to worker threads.
     */

    /**
     * If there is a security manager, makes sure caller has
     * permission to shut down threads in general (see shutdownPerm).
     * If this passes, additionally makes sure the caller is allowed
     * to interrupt each worker thread. This might not be true even if
     * first check passed, if the SecurityManager treats some threads
     * specially.
     */
    private void checkShutdownAccess() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkPermission(shutdownPerm);
            final ReentrantLock mainLock = this.mainLock;
            mainLock.lock();
            try {
                for (Worker w : workers) {
                    security.checkAccess(w.thread);
                }
            } finally {
                mainLock.unlock();
            }
        }
    }

    /**
     * Interrupts all threads, even if active. Ignores SecurityExceptions
     * (in which case some threads may remain uninterrupted).
     * 中断所有正在运行的线程，注意，这里与interruptIdelWorkers()方法不同的是，没有使用worker的AQS锁
     */
    private void interruptWorkers() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            // 中断Worker的执行
            for (Worker w : workers) {

                w.interruptIfStarted();
            }
        } finally {
            mainLock.unlock();
        }
    }

    /**
     * Interrupts threads that might be waiting for tasks (as
     * indicated by not being locked) so they can check for
     * termination or configuration changes. Ignores
     * SecurityExceptions (in which case some threads may remain
     * uninterrupted).
     *
     * @param onlyOne If true, interrupt at most one worker. This is
     *                called only from tryTerminate when termination is otherwise
     *                enabled but there are still other workers.  In this case, at
     *                most one waiting worker is interrupted to propagate shutdown
     *                signals in case all threads are currently waiting.
     *                Interrupting any arbitrary thread ensures that newly arriving
     *                workers since shutdown began will also eventually exit.
     *                To guarantee eventual termination, it suffices to always
     *                interrupt only one idle worker, but shutdown() interrupts all
     *                idle workers so that redundant workers exit promptly, not
     *                waiting for a straggler task to finish.
     */
    //中断空闲线程，没有执行任务的线程会被中断，onlyOne参数用来标识是否只中断一个线程；
    private void interruptIdleWorkers(boolean onlyOne) {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            for (Worker w : workers) {
                Thread t = w.thread;
                // Worker中的线程没有被打断并且Worker可以获取锁，这里Worker能获取锁说明Worker是个闲置Worker，在阻塞队列里拿数据一直被阻塞，
                // 没有数据进来。如果没有获取到Worker锁，说明Worker还在执行任务，不进行中断(shutdown方法不会中断正在执行的任务)
                //如果线程没有被中断，w.tryLock()会调用tryAcquire()方法尝试加锁，加锁成功后会中断线程
                //为什么要w.tryLock(),因为在runWorker()方法的while循环执行任务之前会加锁，如果已经被加锁说明线程正在执行任务，不能被中断；

                if (!t.isInterrupted() && w.tryLock()) {
                    try {
                        t.interrupt();
                    } catch (SecurityException ignore) {
                    } finally {
                        w.unlock();
                    }
                }
                // 如果只打断1个Worker的话，直接break退出，否则，遍历所有的Worker
                if (onlyOne) {
                    break;
                }
            }
        } finally {
            mainLock.unlock();
        }
    }

    /**
     * Common form of interruptIdleWorkers, to avoid having to
     * remember what the boolean argument means.
     */
    private void interruptIdleWorkers() {
        interruptIdleWorkers(false);
    }

    private static final boolean ONLY_ONE = true;

    /*
     * Misc utilities, most of which are also exported to
     * ScheduledThreadPoolExecutor
     */

    /**
     * Invokes the rejected execution handler for the given command.
     * Package-protected for use by ScheduledThreadPoolExecutor.
     */
    final void reject(Runnable command) {
        handler.rejectedExecution(command, this);
    }

    /**
     * Performs any further cleanup following run state transition on
     * invocation of shutdown.  A no-op here, but used by
     * ScheduledThreadPoolExecutor to cancel delayed tasks.
     */
    void onShutdown() {
    }

    /**
     * State check needed by ScheduledThreadPoolExecutor to
     * enable running tasks during shutdown.
     *
     * @param shutdownOK true if should return true if SHUTDOWN
     */
    final boolean isRunningOrShutdown(boolean shutdownOK) {
        int rs = runStateOf(ctl.get());
        return rs == RUNNING || (rs == SHUTDOWN && shutdownOK);
    }

    /**
     * Drains the task queue into a new list, normally using
     * drainTo. But if the queue is a DelayQueue or any other kind of
     * queue for which poll or drainTo may fail to remove some
     * elements, it deletes them one by one.
     */
    private List<Runnable> drainQueue() {
        BlockingQueue<Runnable> q = workQueue;
        ArrayList<Runnable> taskList = new ArrayList<Runnable>();
        q.drainTo(taskList);
        if (!q.isEmpty()) {
            for (Runnable r : q.toArray(new Runnable[0])) {
                if (q.remove(r))
                    taskList.add(r);
            }
        }
        return taskList;
    }

    /*
     * Methods for creating, running and cleaning up after workers
     */

    /**
     * Checks if a new worker can be added with respect to current
     * pool state and the given bound (either core or maximum). If so,
     * the worker count is adjusted accordingly, and, if possible, a
     * new worker is created and started, running firstTask as its
     * first task. This method returns false if the pool is stopped or
     * eligible to shut down. It also returns false if the thread
     * factory fails to create a thread when asked.  If the thread
     * creation fails, either due to the thread factory returning
     * null, or due to an exception (typically OutOfMemoryError in
     * Thread.start()), we roll back cleanly.
     *
     * @param firstTask the task the new thread should run first (or
     *                  null if none). Workers are created with an initial first task
     *                  (in method execute()) to bypass queuing when there are fewer
     *                  than corePoolSize threads (in which case we always start one),
     *                  or when the queue is full (in which case we must bypass queue).
     *                  Initially idle threads are usually created via
     *                  prestartCoreThread or to replace other dying workers.
     * @param core      if true use corePoolSize as bound, else
     *                  maximumPoolSize. (A boolean indicator is used here rather than a
     *                  value to ensure reads of fresh values after checking other pool
     *                  state).
     * @return true if successful
     */

    /**
     * 增加线程时，先判断当前线程池的状态允不允许创建新的线程，如果允许再判断线程池有没有达到 限制，如果条件都满足，才继续执行；
     * 先增加线程数计数 ctl，增加计数成功后，才会去创建线程;
     * 创建线程是通过 work 对象来创建的，创建成功后，将 work 对象放入到 works 线程池中（就是一个 hashSet）;
     * 添加完成后，更新 largestPoolSize 值（线程池中创建过的线程最大数量），最后启动线程，如果参数 firstTask 不为 null，则执行第一个要执行的任务，然后循环去任务队列中取任务来执行；
     * 成功添加 worker 工作线程需要线程池处于以下两种状态中的一种
     * 线程池处于 RUNNING 状态
     * 线程池处于 SHUTDOWN 状态，且创建线程的时候没有传入新的任务（此状态下不接收新任务），且任务队列不为空（此状态下，要执行完任务队列中的剩余任务才能关闭）；
     * 两个参数，firstTask表示需要跑的任务。boolean类型的core参数为true的话表示使用线程池的基本大小，为false使用线程池最大大小
     * 返回值是boolean类型，true表示新任务被接收了，并且执行了。否则是false
     */
    private boolean addWorker(Runnable firstTask, boolean core) {
        //以下for循环，增加线程数计数，ctl，只增加计数，不增加线程，只有增加计数成功，才会增加线程
        retry:
        for (; ; ) {
            int c = ctl.get();
            int rs = runStateOf(c);
            //这个代码块的判断，如果是STOP，TIDYING和TERMINATED这三种状态，都会返回false。(这几种状态不会接收新任务，也不再执行队列中的任务，中断当前执行的任务)
            //如果是SHUTDOWN，firstTask不为空（SHUTDOWN状态下，不会接收新任务）或 者workQueue是空（队列里面都没有任务了，也就不需要线程了），返回false。
            if (rs >= SHUTDOWN && !(rs == SHUTDOWN && firstTask == null && !workQueue.isEmpty())) {
                return false;
            }

            //只有满足以下两种条件才会继续创建worker线程对象
            //1.RUNNING状态，
            //2.shutdown状态，且firstTask为null（因为shutdown状态下不再接收新任务），队列不是空（shutdown状态下需要继续处理队列中的任务）
            // 通过自旋的方式增加线程池线程数
            for (; ; ) {
                int wc = workerCountOf(c);
                // 如果线程池线程数量超过线程池最大限制或者线程数量超过了基本大小(core参数为true，core参数为false的话判断超过最大大小)
                if (wc >= CAPACITY || wc >= (core ? corePoolSize : maximumPoolSize)) {
                    return false;
                }
                // 没有超过各种大小的话，cas操作线程池线程数量+1，cas成功的话跳出循环
                if (compareAndIncrementWorkerCount(c)) {
                    break retry;
                }
                c = ctl.get();  // Re-read ctl
                //否则则判断当前线程池的状态，如果现在获取到的状态与进入自旋的状态不一致的话，那么则通过continue retry重新进行状态的判断
                if (runStateOf(c) != rs) {
                    continue retry;
                }
                // else CAS failed due to workerCount change; retry inner loop
            }
        }

        // 走到这一步说明cas操作成功了，线程池线程数量+1
        boolean workerStarted = false; // 任务是否成功启动标识
        boolean workerAdded = false; // 任务是否添加成功标识
        Worker w = null;
        try {
            w = new Worker(firstTask);
            final Thread t = w.thread;
            if (t != null) { // ThreadFactory构造出的Thread有可能是null，做个判断
                // 得到线程池的可重入锁
                final ReentrantLock mainLock = this.mainLock;
                mainLock.lock();
                try {
                    // Recheck while holding lock.
                    // Back out on ThreadFactory failure or if
                    // shut down before lock acquired.
                    // 在锁住之后再重新检测一下状态
                    int rs = runStateOf(ctl.get());
                    // RUNNING状态 || SHUTDONW状态下，没有新的任务，只是处理任务队列中剩余的任务；
                    if (rs < SHUTDOWN || (rs == SHUTDOWN && firstTask == null)) {
                        //如果线程是活动状态，直接抛出异常，因为线程刚创建，还没有执行start方法，一定不会是活动状态；
                        //这里为什么需要判断下有点奇怪，难道是为了避免不同ThreadFactory  newThread的机制不同？
                        if (t.isAlive()) {// precheck that t is startable
                            // 如果存在已经启动并且还没死的线程，抛出异常
                            throw new IllegalThreadStateException();
                        }
                        // 将新启动的线程添加到线程池中
                        workers.add(w);
                        int s = workers.size();
                        //将线程池中创建过的线程最大数量，设置给largestPoolSize，可以通过getLargestPoolSize()方法获取，注意这个方法只能在 ThreadPoolExecutor中调用，
                        // Executer，ExecuterService，AbstractExecutorService中都是没有这个方法的
                        if (s > largestPoolSize) {
                            largestPoolSize = s;
                        }
                        workerAdded = true;
                    }
                } finally {
                    mainLock.unlock();
                }
                // 启动新添加的线程，这个线程首先执行firstTask，然后不停的从队列中取任务执行
                // 当等待keepAlieTime还没有任务执行则该线程结束。见runWoker和getTask方法的代码。
                if (workerAdded) {// 如果任务添加成功，运行任务，改变一下任务成功启动标识
                    t.start(); // 启动线程，这里的t是Worker中的thread属性，所以相当于就是调用了Worker的run方法
                    workerStarted = true;
                }
            }
        } finally {
            // 如果任务启动失败，调用addWorkerFailed方法
            if (!workerStarted) {
                addWorkerFailed(w);
            }
        }
        return workerStarted;
    }

    /**
     * Rolls back the worker thread creation.
     * - removes worker from workers, if present
     * - decrements worker count
     * - rechecks for termination, in case the existence of this
     * worker was holding up termination
     */
    private void addWorkerFailed(Worker w) {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            if (w != null) {
                workers.remove(w);
            }
            decrementWorkerCount();
            tryTerminate();
        } finally {
            mainLock.unlock();
        }
    }

    /**
     * Performs cleanup and bookkeeping for a dying worker. Called
     * only from worker threads. Unless completedAbruptly is set,
     * assumes that workerCount has already been adjusted to account
     * for exit.  This method removes thread from worker set, and
     * possibly terminates the pool or replaces the worker if either
     * it exited due to user task exception or if fewer than
     * corePoolSize workers are running or queue is non-empty but
     * there are no workers.
     *
     * @param w                 the worker
     * @param completedAbruptly if the worker died due to user exception
     */
    private void processWorkerExit(Worker w, boolean completedAbruptly) {
        // 如果任务运行异常导致则completedAbruptly=true，则将线程池worker线程数减1，如果是没有获取到任务导致的completedAbruptly=false，则会在getTask()方法里面将线程数减1;
        if (completedAbruptly) { // If abrupt, then workerCount wasn't adjusted
            //自旋锁将ctl减1（也就是将线程池中的线程数减1）
            decrementWorkerCount();
        }

        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            //退出前，将本线程已完成的任务数量，添加到已经完成任务的总数中；
            completedTaskCount += w.completedTasks;
            //线程队列中移除当前线程
            workers.remove(w);
        } finally {
            mainLock.unlock();
        }
        // 尝试结束线程池
        tryTerminate();

        /*
         *判断是否要增加新的线程
         *如果满足以下条件则新增线程：
         * 一、当线程池是RUNNING或SHUTDOWN状态，且worker是异常结束，那么会直接addWorker；
         * 二、当线程池是RUNNING或SHUTDOWN状态，且worker是没有任务可做结束的；
         *   1.如果allowCoreThreadTimeOut=true，则判断等待队列不为空  ，且当前线程数是否小于1；
         *   2.如果allowCoreThreadTimeOut=false，则判断当前线程数是否小于corePoolSize；
         *   如果小于，则会创建addWorker线程；
         **/

        int c = ctl.get();
        if (runStateLessThan(c, STOP)) {// 如果线程池还处于RUNNING或者SHUTDOWN状态
            //如果非异常状况completedAbruptly=false，也就是没有获取到可执行的任务，则获取线程池允许的最小线程数，
            // 如果allowCoreThreadTimeOut为true说明允许核心线程超时，则最小线程数为0，否则最小线程数为corePoolSize;
            if (!completedAbruptly) { // Worker是正常结束流程的话
                int min = allowCoreThreadTimeOut ? 0 : corePoolSize;
                //如果allowCoreThreadTimeOut=true，且任务队列有任务要执行，则将最最小线程数设置为1
                if (min == 0 && !workQueue.isEmpty()) {
                    min = 1;
                }
                //如果当前线程数大于等于最小线程数，则直接返回
                if (workerCountOf(c) >= min) {
                    return; // replacement not needed
                }
            }
            //以下两种情况会添加一个新的线程代替原先的Worker
            //1.worker是异常结束；
            //2.如果是非异常结束，且任务队列里面还有任务，
            addWorker(null, false);
        }
    }

    /**
     * Performs blocking or timed wait for a task, depending on
     * current configuration settings, or returns null if this worker
     * must exit because of any of:
     * 1. There are more than maximumPoolSize workers (due to
     * a call to setMaximumPoolSize).
     * 2. The pool is stopped.
     * 3. The pool is shutdown and the queue is empty.
     * 4. This worker timed out waiting for a task, and timed-out
     * workers are subject to termination (that is,
     * {@code allowCoreThreadTimeOut || workerCount > corePoolSize})
     * both before and after the timed wait, and if the queue is
     * non-empty, this worker is not the last thread in the pool.
     *
     * @return task, or null if the worker must exit, in which case
     * workerCount is decremented
     */
    // 如果发生了以下四件事中的任意一件，那么Worker需要被回收：
    // 1. Worker个数比线程池最大大小要大
    // 2. 线程池处于STOP状态
    // 3. 线程池处于SHUTDOWN状态并且阻塞队列为空
    // 4. 使用超时时间从阻塞队列里拿数据，并且超时之后没有拿到数据(allowCoreThreadTimeOut || workerCount > corePoolSize)
    private Runnable getTask() {
        // 如果使用超时时间并且也没有拿到任务的标识
        boolean timedOut = false; // Did the last poll() time out?
        //这是个for循环
        //1.先判断线程池状态是否允许取任务，不允许直接将线程数量减1 ，直接返回null；
        //2.若线程池状态允许取任务，则判断当前线程是否超时 ，若线程超时则将线程池数量减1，直接返回null；
        //3.若没有超时，则去任务队列取任务，取到的话返回任务，若超时则设置超时状态，继续循环，在下次循环中处理超时状态
        for (; ; ) {
            int c = ctl.get();
            int rs = runStateOf(c);

            // Check if queue empty only if necessary.
            // 1.如果是rs > SHUTDOWN，即状态为stop、tidying、terminated；这时不再处理队列中的任务，直接返回null
            // 2.如果是rs = SHUTDOWN ，rs>=STOP不成立，这时还需要处理队列中的任务除非队列为空，没有任务要处理，则返回null
            if (rs >= SHUTDOWN && (rs >= STOP || workQueue.isEmpty())) {
                decrementWorkerCount();
                return null;
            }

            int wc = workerCountOf(c);

            // Are workers subject to culling?
            // allowCoreThreadTimeOut属性默认为false，表示线程池中的核心线程在闲置状态下还保留在池中；如果是true表示核心线程使用keepAliveTime这个参数来作为超时时间
            // 如果worker数量比基本大小要大的话，timed就为true，需要进行回收worker
            boolean timed = allowCoreThreadTimeOut || wc > corePoolSize;

            //超时销毁线程需要先满足以下两个条件之一
            // 1. wc > maximumPoolSize的情况是因为可能在此方法执行阶段同时执行了setMaximumPoolSize方法；
            // 2. timed && timedOut 如果为true，表示当前操作需要进行超时控制，并且上次循环当前线程从任务队列中获取任务发生了超时，没有取到任务；
            //  满足上面两个条件之一的情况下，接下来判断，如果线程数量大于1，或者线程队列是空的，那么尝试将workerCount减1，减1成功则返回null，退出当前线程； 如果减1失败，则返回继续执行循环操作，重试。
            if ((wc > maximumPoolSize || (timed && timedOut)) && (wc > 1 || workQueue.isEmpty())) {
                // worker数量减一，返回null，之后会进行Worker回收工作
                if (compareAndDecrementWorkerCount(c)) {
                    return null;
                }
                //如果将线程池数量减一不成功则循环重试
                continue;
            }

            try {
                //根据timed（是否启用超时控制）来判断执行poll操作还是执行take()操作还是执行有时间限制的poll操作，并返回获取到的任务；
                Runnable r = timed ? workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) : workQueue.take();
                if (r != null) {
                    return r;
                }
                //如果poll操作等待超时,没有取到任务；则将timeOut设置为true；
                timedOut = true;
            } catch (InterruptedException retry) {
                //如果是因为线程中断导致没有取到任务；则设置timedOut=false继续执行循环，取任务
                timedOut = false;
            }
        }
    }

    /**
     * Main worker run loop.  Repeatedly gets tasks from queue and
     * executes them, while coping with a number of issues:
     * 1. We may start out with an initial task, in which case we
     * don't need to get the first one. Otherwise, as long as pool is
     * running, we get tasks from getTask. If it returns null then the
     * worker exits due to changed pool state or configuration
     * parameters.  Other exits result from exception throws in
     * external code, in which case completedAbruptly holds, which
     * usually leads processWorkerExit to replace this thread.
     * 2. Before running any task, the lock is acquired to prevent
     * other pool interrupts while the task is executing, and then we
     * ensure that unless pool is stopping, this thread does not have
     * its interrupt set.
     * 3. Each task run is preceded by a call to beforeExecute, which
     * might throw an exception, in which case we cause thread to die
     * (breaking loop with completedAbruptly true) without processing
     * the task.
     * 4. Assuming beforeExecute completes normally, we run the task,
     * gathering any of its thrown exceptions to send to afterExecute.
     * We separately handle RuntimeException, Error (both of which the
     * specs guarantee that we trap) and arbitrary Throwables.
     * Because we cannot rethrow Throwables within Runnable.run, we
     * wrap them within Errors on the way out (to the thread's
     * UncaughtExceptionHandler).  Any thrown exception also
     * conservatively causes thread to die.
     * 5. After task.run completes, we call afterExecute, which may
     * also throw an exception, which will also cause thread to
     * die. According to JLS Sec 14.20, this exception is the one that
     * will be in effect even if task.run throws.
     * The net effect of the exception mechanics is that afterExecute
     * and the thread's UncaughtExceptionHandler have as accurate
     * information as we can provide about any problems encountered by
     * user code.
     *
     * @param w the worker
     */
    final void runWorker(Worker w) {
        //当前线程
        Thread wt = Thread.currentThread();
        //获取当前Worker线程创建时，指定的第一个要执行的任务，也可以不指定任务，那么它自己就会去任务队列中取任务；
        Runnable task = w.firstTask;
        w.firstTask = null; // 将Worker中的任务置空
        // 在构造方法里面将state设置为了-1，执行该方法就将state置为了0，这样就可以加锁了，-1状态下是无法加锁的，看Worker类的tryAcquire方法
        w.unlock(); // allow interrupts
        //该变量代表任务执行是否发生异常，默认值为true发生了异常，后面会用到这个变量
        boolean completedAbruptly = true;
        try {
            //如果创建worker时传入了第一个任务，则执行第一个任务，否则 从任务队列中获取任务getTask()
            while (task != null || (task = getTask()) != null) {
                // 如果拿到了任务，给自己上锁，表示当前Worker已经要开始执行任务了，已经不是闲置Worker(闲置Worker的解释请看下面的线程池关闭)
                w.lock();

                // If pool is stopping, ensure thread is interrupted;
                // if not, ensure thread is not interrupted.  This
                // requires a recheck in second case to deal with
                // shutdownNow race while clearing interrupt

                // 在执行任务之前先做一些处理。 1. 如果线程池已经处于STOP状态并且当前线程没有被中断，中断线程
                // 2. 如果线程池还处于RUNNING或SHUTDOWN状态，并且当前线程已经被中断了，重新检查一下线程池状态，如果处于STOP状态并且没有被中断，那么中断线程

                //先判断线程池状态是否允许继续执行任务：
                //1.如果是stop<tidying<terminated（这种状态是不接受任务，且不执行任务的），并且线程是非中断状态
                //2.如果线程池还处于RUNNING或SHUTDOWN状态 ，处于中断状态（并复位中断标志），如果这个时候其它线程执行了shutdownNow方法，shutdownNow方法会把状态设置为STOP
                //这个时候则中断线程
                if ((runStateAtLeast(ctl.get(), STOP) || (Thread.interrupted() && runStateAtLeast(ctl.get(), STOP)))
                    && !wt.isInterrupted()) {
                    wt.interrupt();
                }
                try {
                    //任务执行前要做的处理：这个方法是空的，什么都不做，一般会通过继承ThreadPoolExecute类后重写该方法实现自己的功能；传入参数为当前线程与要执行的任务
                    beforeExecute(wt, task);
                    Throwable thrown = null;
                    try {
                        // 真正的开始执行任务，调用的是run方法，而不是start方法。这里run的时候可能会被中断，比如线程池调用了shutdownNow方法
                        task.run();
                    }
                    // 任务执行发生的异常全部抛出，不在runWorker中处理
                    catch (RuntimeException x) {
                        thrown = x;
                        throw x;
                    } catch (Error x) {
                        thrown = x;
                        throw x;
                    } catch (Throwable x) {
                        thrown = x;
                        throw new Error(x);
                    } finally {
                        // 任务执行结束需要做什么，ThreadPoolExecutor是个空实现
                        afterExecute(task, thrown);
                    }
                } finally {
                    task = null;
                    w.completedTasks++; // 记录执行任务的个数
                    w.unlock(); // 执行完任务之后，解锁，Worker变成闲置Worker
                }
            }
            //退出while循环，线程结束
            //判断task.run()方法是否抛出了异常，如果没有则设置它为false，如果发生了异常，前面会直接抛出，中断方法继续执行，就不会执行下面这句；
            completedAbruptly = false;
        } finally {
            //如果getTask返回的是null跳出while 循环 ，那说明阻塞队列已经没有任务并且当前调用getTask的Worker需要被回收，那么会调用processWorkerExit方法进行回收
            processWorkerExit(w, completedAbruptly); // 回收Worker方法
        }
        // 线程如果执行任务过程中，业务代码抛出了异常，那么会将抛出的异常catch以后抛出，如果是Throwable类型的异常，则会封装成Error抛出，最后此线程退出，但是退出之前会将任务完成数照样+1，然后会在控制台上打印Error或者是RuntimeException 异常，这些异常不会被我们捕获，异常信息只会在控制台打出，不会在我们的log日志中打出；
        //所以我们一定要自己去捕获并处理我们的异常，而不能抛出不管；
    }

    // Public constructors and methods

    /**
     * Creates a new {@code ThreadPoolExecutor} with the given initial
     * parameters and default thread factory and rejected execution handler.
     * It may be more convenient to use one of the {@link Executors} factory
     * methods instead of this general purpose constructor.
     *
     * @param corePoolSize    the number of threads to keep in the pool, even
     *                        if they are idle, unless {@code allowCoreThreadTimeOut} is set
     * @param maximumPoolSize the maximum number of threads to allow in the
     *                        pool
     * @param keepAliveTime   when the number of threads is greater than
     *                        the core, this is the maximum time that excess idle threads
     *                        will wait for new tasks before terminating.
     * @param unit            the time unit for the {@code keepAliveTime} argument
     * @param workQueue       the queue to use for holding tasks before they are
     *                        executed.  This queue will hold only the {@code Runnable}
     *                        tasks submitted by the {@code execute} method.
     * @throws IllegalArgumentException if one of the following holds:<br>
     *                                  {@code corePoolSize < 0}<br>
     *                                  {@code keepAliveTime < 0}<br>
     *                                  {@code maximumPoolSize <= 0}<br>
     *                                  {@code maximumPoolSize < corePoolSize}
     * @throws NullPointerException     if {@code workQueue} is null
     */
    public YKThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                                BlockingQueue<Runnable> workQueue) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, Executors.defaultThreadFactory(),
             defaultHandler);
    }

    /**
     * Creates a new {@code ThreadPoolExecutor} with the given initial
     * parameters and default rejected execution handler.
     *
     * @param corePoolSize    the number of threads to keep in the pool, even
     *                        if they are idle, unless {@code allowCoreThreadTimeOut} is set
     * @param maximumPoolSize the maximum number of threads to allow in the
     *                        pool
     * @param keepAliveTime   when the number of threads is greater than
     *                        the core, this is the maximum time that excess idle threads
     *                        will wait for new tasks before terminating.
     * @param unit            the time unit for the {@code keepAliveTime} argument
     * @param workQueue       the queue to use for holding tasks before they are
     *                        executed.  This queue will hold only the {@code Runnable}
     *                        tasks submitted by the {@code execute} method.
     * @param threadFactory   the factory to use when the executor
     *                        creates a new thread
     * @throws IllegalArgumentException if one of the following holds:<br>
     *                                  {@code corePoolSize < 0}<br>
     *                                  {@code keepAliveTime < 0}<br>
     *                                  {@code maximumPoolSize <= 0}<br>
     *                                  {@code maximumPoolSize < corePoolSize}
     * @throws NullPointerException     if {@code workQueue}
     *                                  or {@code threadFactory} is null
     */
    public YKThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                                BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, defaultHandler);
    }

    /**
     * Creates a new {@code ThreadPoolExecutor} with the given initial
     * parameters and default thread factory.
     *
     * @param corePoolSize    the number of threads to keep in the pool, even
     *                        if they are idle, unless {@code allowCoreThreadTimeOut} is set
     * @param maximumPoolSize the maximum number of threads to allow in the
     *                        pool
     * @param keepAliveTime   when the number of threads is greater than
     *                        the core, this is the maximum time that excess idle threads
     *                        will wait for new tasks before terminating.
     * @param unit            the time unit for the {@code keepAliveTime} argument
     * @param workQueue       the queue to use for holding tasks before they are
     *                        executed.  This queue will hold only the {@code Runnable}
     *                        tasks submitted by the {@code execute} method.
     * @param handler         the handler to use when execution is blocked
     *                        because the thread bounds and queue capacities are reached
     * @throws IllegalArgumentException if one of the following holds:<br>
     *                                  {@code corePoolSize < 0}<br>
     *                                  {@code keepAliveTime < 0}<br>
     *                                  {@code maximumPoolSize <= 0}<br>
     *                                  {@code maximumPoolSize < corePoolSize}
     * @throws NullPointerException     if {@code workQueue}
     *                                  or {@code handler} is null
     */
    public YKThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                                BlockingQueue<Runnable> workQueue, YKRejectedExecutionHandler handler) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, Executors.defaultThreadFactory(), handler);
    }

    /**
     * Creates a new {@code ThreadPoolExecutor} with the given initial
     * parameters.
     *
     * @param corePoolSize    the number of threads to keep in the pool, even
     *                        if they are idle, unless {@code allowCoreThreadTimeOut} is set
     * @param maximumPoolSize the maximum number of threads to allow in the
     *                        pool
     * @param keepAliveTime   when the number of threads is greater than
     *                        the core, this is the maximum time that excess idle threads
     *                        will wait for new tasks before terminating.
     * @param unit            the time unit for the {@code keepAliveTime} argument
     * @param workQueue       the queue to use for holding tasks before they are
     *                        executed.  This queue will hold only the {@code Runnable}
     *                        tasks submitted by the {@code execute} method.
     * @param threadFactory   the factory to use when the executor
     *                        creates a new thread
     * @param handler         the handler to use when execution is blocked
     *                        because the thread bounds and queue capacities are reached
     * @throws IllegalArgumentException if one of the following holds:<br>
     *                                  {@code corePoolSize < 0}<br>
     *                                  {@code keepAliveTime < 0}<br>
     *                                  {@code maximumPoolSize <= 0}<br>
     *                                  {@code maximumPoolSize < corePoolSize}
     * @throws NullPointerException     if {@code workQueue}
     *                                  or {@code threadFactory} or {@code handler} is null
     */
    public YKThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                                BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory,
                                YKRejectedExecutionHandler handler) {
        if (corePoolSize < 0 || maximumPoolSize <= 0 || maximumPoolSize < corePoolSize || keepAliveTime < 0)
            throw new IllegalArgumentException();
        if (workQueue == null || threadFactory == null || handler == null)
            throw new NullPointerException();
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        this.threadFactory = threadFactory;
        this.handler = handler;
    }

    /**
     * 添加新任务
     * Executes the given task sometime in the future.  The task
     * may execute in a new thread or in an existing pooled thread.
     * If the task cannot be submitted for execution, either because this
     * executor has been shutdown or because its capacity has been reached,
     * the task is handled by the current {@code RejectedExecutionHandler}.
     *
     * @param command the task to execute
     * @throws RejectedExecutionException at discretion of
     *                                    {@code RejectedExecutionHandler}, if the task
     *                                    cannot be accepted for execution
     * @throws NullPointerException       if {@code command} is null
     */
    @Override
    public void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException();
        }
        /*
         * Proceed in 3 steps:
         *
         * 1. If fewer than corePoolSize threads are running, try to
         * start a new thread with the given command as its first
         * task.  The call to addWorker atomically checks runState and
         * workerCount, and so prevents false alarms that would add
         * threads when it shouldn't, by returning false.
         *
         * 2. If a task can be successfully queued, then we still need
         * to double-check whether we should have added a thread
         * (because existing ones died since last checking) or that
         * the pool shut down since entry into this method. So we
         * recheck state and if necessary roll back the enqueuing if
         * stopped, or start a new thread if there are none.
         *
         * 3. If we cannot queue task, then we try to add a new
         * thread.  If it fails, we know we are shut down or saturated
         * and so reject the task.
         */
        //获取当前线程池的ctl值，不知道它作用的看前面说明
        int c = ctl.get();
        // 第一个步骤，满足线程池中的线程大小比基本大小要小
        //如果当前线程数小于核心线程数，这时候任务不会进入任务队列，会创建新的工作线程直接执行任务；
        if (workerCountOf(c) < corePoolSize) {
            //添加新的工作线程执行任务
            // addWorker方法第二个参数true表示使用基本大小
            if (addWorker(command, true)) {
                return;
            }
            //addWorker操作返回false，说明添加新的工作线程失败，则获取当前线程池状态；要么是线程池大小发生了变化，要么是线程池状态发生了变化
            // （线程池数量小于corePoolSize情况下，创建新的工作线程失败，是因为线程池的状态发生了改变，已经处于非Running状态，或shutdown状态且任务队列为空）
            c = ctl.get();
        }

        //以下两种情况继续执行后面代码
        //1.前面的判断中，线程池中线程数小于核心线程数，并且创建新的工作线程失败；
        //2.前面的判断中，线程池中线程数大于等于核心线程数

        // 线程池处于RUNNING状态，说明线程池中线程已经>=corePoolSize,这时候要将任务放入队列中，等待执行;
        if (isRunning(c) && workQueue.offer(command)) {
            int recheck = ctl.get();
            //再次检查线程池的状态，如果线程池状态变了，非RUNNING状态下不会接收新的任务，需要将任务移除，成功从队列中删除任务，则执行reject方法处理任务；
            if (!isRunning(recheck) && remove(command)) {
                reject(command);
            }
            //如果线程池的状态没有改变，且池中无线程
            else if (workerCountOf(recheck) == 0) {
                // 两种情况进入以该分支
                //1.线程池处于RUNNING状态，线程池中没有线程了，因为有新任务进入队列所以要创建工作线程
                // （这时候新任务已经在队列中，所以下面创建worker线程时第一个参数，要执行的任务为null，只是创建一个新的工作线程并启动它，让它自己去队列中取任务执行）
                //2.线程池处于非RUNNING状态但是任务移除失败,导致任务队列中仍然有任务，但是线程池中的线程数为0，则创建新的工作线程，处理队列中的任务；
                addWorker(null, false);
            }
        }
        // 两种情况执行下面分支：
        // 1.非RUNNING状态拒绝新的任务,并且无法创建新的线程，则拒绝任务
        // 2.线程池处于RUNNING状态，线程池线程数量已经大于等于coresize，任务就需要放入队列，如果任务入队失败，说明队列满了，则创建新的线程，
        // 创建成功则新线程继续执行任务，如果创建失败说明线程池中线程数已经超过maximumPoolSize，则拒绝任务
        else if (!addWorker(command, false)) {
            reject(command);
        }
    }

    /**
     * Initiates an orderly shutdown in which previously submitted
     * tasks are executed, but no new tasks will be accepted.
     * Invocation has no additional effect if already shut down.
     * <p>This method does not wait for previously submitted tasks to
     * complete execution.  Use {@link #awaitTermination awaitTermination}
     * to do that.
     *
     * @throws SecurityException {@inheritDoc}
     */
    @Override
    public void shutdown() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            // 检查关闭线程池的权限
            checkShutdownAccess();
            // 线程池状态设为SHUTDOWN，如果已经是shutdown<stop<tidying<terminated，也就是非RUNING状态则直接返回
            advanceRunState(SHUTDOWN);
            // 中断闲置的Worker
            interruptIdleWorkers();
            // 钩子方法，默认不处理。ScheduledThreadPoolExecutor会做一些处理
            onShutdown(); // hook for ScheduledThreadPoolExecutor
        } finally {
            mainLock.unlock();
        }
        tryTerminate();
    }

    /**
     * Attempts to stop all actively executing tasks, halts the
     * processing of waiting tasks, and returns a list of the tasks
     * that were awaiting execution. These tasks are drained (removed)
     * from the task queue upon return from this method.
     * <p>This method does not wait for actively executing tasks to
     * terminate.  Use {@link #awaitTermination awaitTermination} to
     * do that.
     * <p>There are no guarantees beyond best-effort attempts to stop
     * processing actively executing tasks.  This implementation
     * cancels tasks via {@link Thread#interrupt}, so any task that
     * fails to respond to interrupts may never terminate.
     *
     * @throws SecurityException {@inheritDoc}
     */
    @Override
    public List<Runnable> shutdownNow() {
        List<Runnable> tasks;
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            checkShutdownAccess();
            advanceRunState(STOP);
            // 中断所有线程，无论空闲还是在执行任务
            interruptWorkers();
            //将任务队列清空，并返回队列中还没有被执行的任务。
            tasks = drainQueue();
        } finally {
            mainLock.unlock();
        }
        tryTerminate();
        return tasks;
    }

    public boolean isShutdown() {
        return !isRunning(ctl.get());
    }

    /**
     * Returns true if this executor is in the process of terminating
     * after {@link #shutdown} or {@link #shutdownNow} but has not
     * completely terminated.  This method may be useful for
     * debugging. A return of {@code true} reported a sufficient
     * period after shutdown may indicate that submitted tasks have
     * ignored or suppressed interruption, causing this executor not
     * to properly terminate.
     *
     * @return {@code true} if terminating but not yet terminated
     */
    public boolean isTerminating() {
        int c = ctl.get();
        return !isRunning(c) && runStateLessThan(c, TERMINATED);
    }

    public boolean isTerminated() {
        return runStateAtLeast(ctl.get(), TERMINATED);
    }

    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            for (; ; ) {
                if (runStateAtLeast(ctl.get(), TERMINATED))
                    return true;
                if (nanos <= 0)
                    return false;
                nanos = termination.awaitNanos(nanos);
            }
        } finally {
            mainLock.unlock();
        }
    }

    /**
     * Invokes {@code shutdown} when this executor is no longer
     * referenced and it has no threads.
     */
    protected void finalize() {
        shutdown();
    }

    /**
     * Sets the thread factory used to create new threads.
     *
     * @param threadFactory the new thread factory
     * @throws NullPointerException if threadFactory is null
     * @see #getThreadFactory
     */
    public void setThreadFactory(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException();
        }
        this.threadFactory = threadFactory;
    }

    /**
     * Returns the thread factory used to create new threads.
     *
     * @return the current thread factory
     * @see #setThreadFactory(ThreadFactory)
     */
    public ThreadFactory getThreadFactory() {
        return threadFactory;
    }

    /**
     * Sets a new handler for unexecutable tasks.
     *
     * @param handler the new handler
     * @throws NullPointerException if handler is null
     * @see #getRejectedExecutionHandler
     */
    public void setRejectedExecutionHandler(YKRejectedExecutionHandler handler) {
        if (handler == null)
            throw new NullPointerException();
        this.handler = handler;
    }

    /**
     * Returns the current handler for unexecutable tasks.
     *
     * @return the current handler
     * @see #setRejectedExecutionHandler(YKRejectedExecutionHandler)
     */
    public YKRejectedExecutionHandler getRejectedExecutionHandler() {
        return handler;
    }

    /**
     * Sets the core number of threads.  This overrides any value set
     * in the constructor.  If the new value is smaller than the
     * current value, excess existing threads will be terminated when
     * they next become idle.  If larger, new threads will, if needed,
     * be started to execute any queued tasks.
     *
     * @param corePoolSize the new core size
     * @throws IllegalArgumentException if {@code corePoolSize < 0}
     * @see #getCorePoolSize
     */
    public void setCorePoolSize(int corePoolSize) {
        if (corePoolSize < 0)
            throw new IllegalArgumentException();
        int delta = corePoolSize - this.corePoolSize;
        this.corePoolSize = corePoolSize;
        if (workerCountOf(ctl.get()) > corePoolSize)
            interruptIdleWorkers();
        else if (delta > 0) {
            // We don't really know how many new threads are "needed".
            // As a heuristic, prestart enough new workers (up to new
            // core size) to handle the current number of tasks in
            // queue, but stop if queue becomes empty while doing so.
            int k = Math.min(delta, workQueue.size());
            while (k-- > 0 && addWorker(null, true)) {
                if (workQueue.isEmpty())
                    break;
            }
        }
    }

    /**
     * Returns the core number of threads.
     *
     * @return the core number of threads
     * @see #setCorePoolSize
     */
    public int getCorePoolSize() {
        return corePoolSize;
    }

    /**
     * Starts a core thread, causing it to idly wait for work. This
     * overrides the default policy of starting core threads only when
     * new tasks are executed. This method will return {@code false}
     * if all core threads have already been started.
     *
     * @return {@code true} if a thread was started
     */
    public boolean prestartCoreThread() {
        return workerCountOf(ctl.get()) < corePoolSize && addWorker(null, true);
    }

    /**
     * Same as prestartCoreThread except arranges that at least one
     * thread is started even if corePoolSize is 0.
     */
    void ensurePrestart() {
        int wc = workerCountOf(ctl.get());
        if (wc < corePoolSize)
            addWorker(null, true);
        else if (wc == 0)
            addWorker(null, false);
    }

    /**
     * Starts all core threads, causing them to idly wait for work. This
     * overrides the default policy of starting core threads only when
     * new tasks are executed.
     *
     * @return the number of threads started
     */
    public int prestartAllCoreThreads() {
        int n = 0;
        while (addWorker(null, true))
            ++n;
        return n;
    }

    /**
     * Returns true if this pool allows core threads to time out and
     * terminate if no tasks arrive within the keepAlive time, being
     * replaced if needed when new tasks arrive. When true, the same
     * keep-alive policy applying to non-core threads applies also to
     * core threads. When false (the default), core threads are never
     * terminated due to lack of incoming tasks.
     *
     * @return {@code true} if core threads are allowed to time out,
     * else {@code false}
     * @since 1.6
     */
    public boolean allowsCoreThreadTimeOut() {
        return allowCoreThreadTimeOut;
    }

    /**
     * Sets the policy governing whether core threads may time out and
     * terminate if no tasks arrive within the keep-alive time, being
     * replaced if needed when new tasks arrive. When false, core
     * threads are never terminated due to lack of incoming
     * tasks. When true, the same keep-alive policy applying to
     * non-core threads applies also to core threads. To avoid
     * continual thread replacement, the keep-alive time must be
     * greater than zero when setting {@code true}. This method
     * should in general be called before the pool is actively used.
     *
     * @param value {@code true} if should time out, else {@code false}
     * @throws IllegalArgumentException if value is {@code true}
     *                                  and the current keep-alive time is not greater than zero
     * @since 1.6
     */
    public void allowCoreThreadTimeOut(boolean value) {
        if (value && keepAliveTime <= 0)
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        if (value != allowCoreThreadTimeOut) {
            allowCoreThreadTimeOut = value;
            if (value)
                interruptIdleWorkers();
        }
    }

    /**
     * Sets the maximum allowed number of threads. This overrides any
     * value set in the constructor. If the new value is smaller than
     * the current value, excess existing threads will be
     * terminated when they next become idle.
     *
     * @param maximumPoolSize the new maximum
     * @throws IllegalArgumentException if the new maximum is
     *                                  less than or equal to zero, or
     *                                  less than the {@linkplain #getCorePoolSize core pool size}
     * @see #getMaximumPoolSize
     */
    public void setMaximumPoolSize(int maximumPoolSize) {
        if (maximumPoolSize <= 0 || maximumPoolSize < corePoolSize)
            throw new IllegalArgumentException();
        this.maximumPoolSize = maximumPoolSize;
        if (workerCountOf(ctl.get()) > maximumPoolSize)
            interruptIdleWorkers();
    }

    /**
     * Returns the maximum allowed number of threads.
     *
     * @return the maximum allowed number of threads
     * @see #setMaximumPoolSize
     */
    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    /**
     * Sets the time limit for which threads may remain idle before
     * being terminated.  If there are more than the core number of
     * threads currently in the pool, after waiting this amount of
     * time without processing a task, excess threads will be
     * terminated.  This overrides any value set in the constructor.
     *
     * @param time the time to wait.  A time value of zero will cause
     *             excess threads to terminate immediately after executing tasks.
     * @param unit the time unit of the {@code time} argument
     * @throws IllegalArgumentException if {@code time} less than zero or
     *                                  if {@code time} is zero and {@code allowsCoreThreadTimeOut}
     * @see #getKeepAliveTime(TimeUnit)
     */
    public void setKeepAliveTime(long time, TimeUnit unit) {
        if (time < 0)
            throw new IllegalArgumentException();
        if (time == 0 && allowsCoreThreadTimeOut())
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        long keepAliveTime = unit.toNanos(time);
        long delta = keepAliveTime - this.keepAliveTime;
        this.keepAliveTime = keepAliveTime;
        if (delta < 0)
            interruptIdleWorkers();
    }

    /**
     * Returns the thread keep-alive time, which is the amount of time
     * that threads in excess of the core pool size may remain
     * idle before being terminated.
     *
     * @param unit the desired time unit of the result
     * @return the time limit
     * @see #setKeepAliveTime(long, TimeUnit)
     */
    public long getKeepAliveTime(TimeUnit unit) {
        return unit.convert(keepAliveTime, TimeUnit.NANOSECONDS);
    }

    /* User-level queue utilities */

    /**
     * Returns the task queue used by this executor. Access to the
     * task queue is intended primarily for debugging and monitoring.
     * This queue may be in active use.  Retrieving the task queue
     * does not prevent queued tasks from executing.
     *
     * @return the task queue
     */
    public BlockingQueue<Runnable> getQueue() {
        return workQueue;
    }

    /**
     * Removes this task from the executor's internal queue if it is
     * present, thus causing it not to be run if it has not already
     * started.
     * <p>This method may be useful as one part of a cancellation
     * scheme.  It may fail to remove tasks that have been converted
     * into other forms before being placed on the internal queue. For
     * example, a task entered using {@code submit} might be
     * converted into a form that maintains {@code Future} status.
     * However, in such cases, method {@link #purge} may be used to
     * remove those Futures that have been cancelled.
     *
     * @param task the task to remove
     * @return {@code true} if the task was removed
     */
    public boolean remove(Runnable task) {
        boolean removed = workQueue.remove(task);
        tryTerminate(); // In case SHUTDOWN and now empty
        return removed;
    }

    /**
     * Tries to remove from the work queue all {@link Future}
     * tasks that have been cancelled. This method can be useful as a
     * storage reclamation operation, that has no other impact on
     * functionality. Cancelled tasks are never executed, but may
     * accumulate in work queues until worker threads can actively
     * remove them. Invoking this method instead tries to remove them now.
     * However, this method may fail to remove tasks in
     * the presence of interference by other threads.
     */
    public void purge() {
        final BlockingQueue<Runnable> q = workQueue;
        try {
            Iterator<Runnable> it = q.iterator();
            while (it.hasNext()) {
                Runnable r = it.next();
                if (r instanceof Future<?> && ((Future<?>) r).isCancelled())
                    it.remove();
            }
        } catch (ConcurrentModificationException fallThrough) {
            // Take slow path if we encounter interference during traversal.
            // Make copy for traversal and call remove for cancelled entries.
            // The slow path is more likely to be O(N*N).
            for (Object r : q.toArray())
                if (r instanceof Future<?> && ((Future<?>) r).isCancelled())
                    q.remove(r);
        }

        tryTerminate(); // In case SHUTDOWN and now empty
    }

    /* Statistics */

    /**
     * Returns the current number of threads in the pool.
     *
     * @return the number of threads
     */
    public int getPoolSize() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            // Remove rare and surprising possibility of
            // isTerminated() && getPoolSize() > 0
            return runStateAtLeast(ctl.get(), TIDYING) ? 0 : workers.size();
        } finally {
            mainLock.unlock();
        }
    }

    /**
     * Returns the approximate number of threads that are actively
     * executing tasks.
     *
     * @return the number of threads
     */
    public int getActiveCount() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            int n = 0;
            for (Worker w : workers)
                if (w.isLocked())
                    ++n;
            return n;
        } finally {
            mainLock.unlock();
        }
    }

    /**
     * Returns the largest number of threads that have ever
     * simultaneously been in the pool.
     *
     * @return the number of threads
     */
    public int getLargestPoolSize() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            return largestPoolSize;
        } finally {
            mainLock.unlock();
        }
    }

    /**
     * Returns the approximate total number of tasks that have ever been
     * scheduled for execution. Because the states of tasks and
     * threads may change dynamically during computation, the returned
     * value is only an approximation.
     *
     * @return the number of tasks
     */
    public long getTaskCount() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            long n = completedTaskCount;
            for (Worker w : workers) {
                n += w.completedTasks;
                if (w.isLocked())
                    ++n;
            }
            return n + workQueue.size();
        } finally {
            mainLock.unlock();
        }
    }

    /**
     * Returns the approximate total number of tasks that have
     * completed execution. Because the states of tasks and threads
     * may change dynamically during computation, the returned value
     * is only an approximation, but one that does not ever decrease
     * across successive calls.
     *
     * @return the number of tasks
     */
    public long getCompletedTaskCount() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            long n = completedTaskCount;
            for (Worker w : workers)
                n += w.completedTasks;
            return n;
        } finally {
            mainLock.unlock();
        }
    }

    /**
     * Returns a string identifying this pool, as well as its state,
     * including indications of run state and estimated worker and
     * task counts.
     *
     * @return a string identifying this pool, as well as its state
     */
    public String toString() {
        long ncompleted;
        int nworkers, nactive;
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            ncompleted = completedTaskCount;
            nactive = 0;
            nworkers = workers.size();
            for (Worker w : workers) {
                ncompleted += w.completedTasks;
                if (w.isLocked())
                    ++nactive;
            }
        } finally {
            mainLock.unlock();
        }
        int c = ctl.get();
        String rs = (runStateLessThan(c, SHUTDOWN) ? "Running" : (runStateAtLeast(c,
                                                                                  TERMINATED) ? "Terminated" : "Shutting down"));
        return super.toString() + "[" + rs + ", pool size = " + nworkers + ", active threads = " + nactive
               + ", queued tasks = " + workQueue.size() + ", completed tasks = " + ncompleted + "]";
    }

    /* Extension hooks */

    /**
     * Method invoked prior to executing the given Runnable in the
     * given thread.  This method is invoked by thread {@code t} that
     * will execute task {@code r}, and may be used to re-initialize
     * ThreadLocals, or to perform logging.
     * <p>This implementation does nothing, but may be customized in
     * subclasses. Note: To properly nest multiple overridings, subclasses
     * should generally invoke {@code super.beforeExecute} at the end of
     * this method.
     *
     * @param t the thread that will run task {@code r}
     * @param r the task that will be executed
     */
    protected void beforeExecute(Thread t, Runnable r) {
    }

    /**
     * Method invoked upon completion of execution of the given Runnable.
     * This method is invoked by the thread that executed the task. If
     * non-null, the Throwable is the uncaught {@code RuntimeException}
     * or {@code Error} that caused execution to terminate abruptly.
     * <p>This implementation does nothing, but may be customized in
     * subclasses. Note: To properly nest multiple overridings, subclasses
     * should generally invoke {@code super.afterExecute} at the
     * beginning of this method.
     * <p><b>Note:</b> When actions are enclosed in tasks (such as
     * {@link FutureTask}) either explicitly or via methods such as
     * {@code submit}, these task objects catch and maintain
     * computational exceptions, and so they do not cause abrupt
     * termination, and the internal exceptions are <em>not</em>
     * passed to this method. If you would like to trap both kinds of
     * failures in this method, you can further probe for such cases,
     * as in this sample subclass that prints either the direct cause
     * or the underlying exception if a task has been aborted:
     * <pre> {@code
     * class ExtendedExecutor extends ThreadPoolExecutor {
     *   // ...
     *   protected void afterExecute(Runnable r, Throwable t) {
     *     super.afterExecute(r, t);
     *     if (t == null && r instanceof Future<?>) {
     *       try {
     *         Object result = ((Future<?>) r).get();
     *       } catch (CancellationException ce) {
     *           t = ce;
     *       } catch (ExecutionException ee) {
     *           t = ee.getCause();
     *       } catch (InterruptedException ie) {
     *           Thread.currentThread().interrupt(); // ignore/reset
     *       }
     *     }
     *     if (t != null)
     *       System.out.println(t);
     *   }
     * }}</pre>
     *
     * @param r the runnable that has completed
     * @param t the exception that caused termination, or null if
     *          execution completed normally
     */
    protected void afterExecute(Runnable r, Throwable t) {
    }

    /**
     * Method invoked when the Executor has terminated.  Default
     * implementation does nothing. Note: To properly nest multiple
     * overridings, subclasses should generally invoke
     * {@code super.terminated} within this method.
     */
    protected void terminated() {
    }

    /* Predefined RejectedExecutionHandlers */

    /**
     * A handler for rejected tasks that runs the rejected task
     * directly in the calling thread of the {@code execute} method,
     * unless the executor has been shut down, in which case the task
     * is discarded.
     */
    public static class CallerRunsPolicy implements YKRejectedExecutionHandler {

        /**
         * Creates a {@code CallerRunsPolicy}.
         */
        public CallerRunsPolicy() {
        }

        /**
         * Executes task r in the caller's thread, unless the executor
         * has been shut down, in which case the task is discarded.
         *
         * @param r the runnable task requested to be executed
         * @param e the executor attempting to execute this task
         */
        public void rejectedExecution(Runnable r, YKThreadPoolExecutor e) {
            if (!e.isShutdown()) {
                r.run();
            }
        }
    }

    public interface YKRejectedExecutionHandler {

        void rejectedExecution(Runnable r, YKThreadPoolExecutor executor);
    }

    /**
     * A handler for rejected tasks that throws a
     * {@code RejectedExecutionException}.
     */
    public static class AbortPolicy implements YKRejectedExecutionHandler {

        /**
         * Creates an {@code AbortPolicy}.
         */
        public AbortPolicy() {
        }

        /**
         * Always throws RejectedExecutionException.
         *
         * @param r the runnable task requested to be executed
         * @param e the executor attempting to execute this task
         * @throws RejectedExecutionException always
         */
        public void rejectedExecution(Runnable r, YKThreadPoolExecutor e) {
            throw new RejectedExecutionException("Task " + r.toString() + " rejected from " + e.toString());
        }
    }

    /**
     * A handler for rejected tasks that silently discards the
     * rejected task.
     */
    public static class DiscardPolicy implements YKRejectedExecutionHandler {

        /**
         * Creates a {@code DiscardPolicy}.
         */
        public DiscardPolicy() {
        }

        /**
         * Does nothing, which has the effect of discarding task r.
         *
         * @param r the runnable task requested to be executed
         * @param e the executor attempting to execute this task
         */
        public void rejectedExecution(Runnable r, YKThreadPoolExecutor e) {
        }
    }

    /**
     * A handler for rejected tasks that discards the oldest unhandled
     * request and then retries {@code execute}, unless the executor
     * is shut down, in which case the task is discarded.
     */
    public static class DiscardOldestPolicy implements YKRejectedExecutionHandler {

        /**
         * Creates a {@code DiscardOldestPolicy} for the given executor.
         */
        public DiscardOldestPolicy() {
        }

        /**
         * Obtains and ignores the next task that the executor
         * would otherwise execute, if one is immediately available,
         * and then retries execution of task r, unless the executor
         * is shut down, in which case task r is instead discarded.
         *
         * @param r the runnable task requested to be executed
         * @param e the executor attempting to execute this task
         */
        public void rejectedExecution(Runnable r, YKThreadPoolExecutor e) {
            if (!e.isShutdown()) {
                e.getQueue().poll();
                e.execute(r);
            }
        }
    }
}
