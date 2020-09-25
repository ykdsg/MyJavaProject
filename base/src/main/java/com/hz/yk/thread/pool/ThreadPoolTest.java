package com.hz.yk.thread.pool;

import com.hz.yk.thread.YKThreadPoolExecutor;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.hz.yk.thread.RunnableUtils.buildMyPool;
import static com.hz.yk.thread.RunnableUtils.cpuRun;

/**
 * @author wuzheng.yk
 * @date 2020/6/19
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        testPool();
    }

    public static void testPool() throws InterruptedException {
        System.out.println("all start");
        YKThreadPoolExecutor threadPoolExecutor = buildMyPool();

        Thread.sleep(3000);
        System.out.println("warmup end,start 1 runnable");
        for (int i = 0; i < 3; i++) {
            threadPoolExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread() + "start");
                    cpuRun(500000);
                    System.out.println(Thread.currentThread() + "end");
                }
            });
        }

        System.out.println("all end");
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

