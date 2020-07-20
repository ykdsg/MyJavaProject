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

