package com.hz.yk.thread.pool;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;
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
    public void testOneSameRunnable() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS,
                                                                       new LinkedBlockingDeque());

        TestTask task = new TestTask();
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(task);
        }

    }

    static class TestTask implements Runnable {

        @Override
        public void run() {
            System.out.println("thread=" + Thread.currentThread());
        }
    }
}

