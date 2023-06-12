package com.hz.yk.thread.pool;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wuzheng.yk
 * @date 2020/6/19
 */
public class ThreadPoolTest {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    /**
     * 可以接受新的任务，也可以处理阻塞队列里的任务
     */
    private static final int RUNNING = -1 << COUNT_BITS;
    /**
     * 不接受新的任务，但是可以处理阻塞队列里的任务
     */
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    /**
     * 不接受新的任务，不处理阻塞队列里的任务，中断正在处理的任务
     */
    private static final int STOP = 1 << COUNT_BITS;
    /**
     * 过渡状态，也就是说所有的任务都执行完了，当前线程池已经没有有效的线程，这个时候线程池的状态将会TIDYING，并且将要调用terminated方法
     */
    private static final int TIDYING = 2 << COUNT_BITS;
    /**
     * 终止状态。terminated方法调用完成以后的状态
     */
    private static final int TERMINATED = 3 << COUNT_BITS;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(RUNNING);
        System.out.println(SHUTDOWN);
        System.out.println(STOP);
        System.out.println(TIDYING);
    }

    @Test
    public void testOneSameRunnable() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS,
                                                                       new LinkedBlockingDeque());

        TestTask task = new TestTask();
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(task);
            System.out.println("当前活动线程：" + threadPoolExecutor.getActiveCount());
            System.out.println("当前线程池大小：" + threadPoolExecutor.getPoolSize());
        }

        Thread.sleep(3000);
    }

    @Test
    public void testThrowException() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS,
                                                                       new LinkedBlockingDeque());
        threadPoolExecutor.execute(new TestTask());
        System.out.println("当前线程池大小：" + threadPoolExecutor.getPoolSize());
        System.out.println("当前活跃线程数：" + threadPoolExecutor.getActiveCount());

        Thread.sleep(2000);
        threadPoolExecutor.execute(new Runnable() {

            @Override
            public void run() {
                throw new RuntimeException("just test");
            }
        });

        System.out.println("当前线程池大小：" + threadPoolExecutor.getPoolSize());
        System.out.println("当前活跃线程数：" + threadPoolExecutor.getActiveCount());

    }

    /**
     * 通过UncaughtExceptionHandler 可以统一控制线程这边抛出的异常
     * 从线程名称打印来看，如果在运行期间抛出异常，当前线程会被销毁，虽然线程池会再创建新的线程，但是如果这个步骤反复执行，效率会下降很多。
     * 因此uncaughtExceptionHandler 可以作为兜底的机制进行日志输出，但是标准的处理方式还是应该在run方法里用try块包围。
     */
    @Test
    public void testUncaughtExceptionHandler() throws InterruptedException {
        ThreadFactory executorThreadFactory = new BasicThreadFactory.Builder().namingPattern("task-scanner-executor-%d")
                .uncaughtExceptionHandler(new LogUncaughtExceptionHandler()).build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS,
                                                                       new LinkedBlockingDeque(),
                                                                       executorThreadFactory);

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println("thread name:" + Thread.currentThread().getName());
                    System.out.println(
                            Thread.currentThread().getName() + " pool size :" + threadPoolExecutor.getPoolSize());
                    System.out.println(
                            Thread.currentThread().getName() + " queue size :" + threadPoolExecutor.getQueue().size());
                    System.out.println(
                            Thread.currentThread().getName() + " active count :" + threadPoolExecutor.getActiveCount());
                    System.out.println(Thread.currentThread().getName() + " completed count :" + threadPoolExecutor
                            .getCompletedTaskCount());
                    throw new RuntimeException("just test");
                }
            });
        }

        System.out.println("当前线程池大小：" + threadPoolExecutor.getPoolSize());
        System.out.println("当前活跃线程数：" + threadPoolExecutor.getActiveCount());

    }

    static class LogUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + "，state：" + t.getState() + ",exception:" + e.getMessage());
        }
    }

    static class TestTask implements Runnable {

        @Override
        public void run() {
            System.out.println("thread=" + Thread.currentThread());
        }
    }
}

