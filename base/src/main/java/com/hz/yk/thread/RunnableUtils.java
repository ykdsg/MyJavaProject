package com.hz.yk.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 体用方便的一些操作
 *
 * @author wuzheng.yk
 * @date 2020/9/24
 */
public class RunnableUtils {

    /**
     * 模拟cpu运行
     *
     * @param duration
     */
    public static void cpuRun(long duration) {

        final long startTime = System.currentTimeMillis();
        int num = 0;
        while (true) {
            num++;
            if (num == Integer.MAX_VALUE) {
                System.out.println(Thread.currentThread() + "rest");
                num = 0;
            }
            if (System.currentTimeMillis() - startTime > duration) {
                return;
            }
        }
    }

    public static ThreadPoolExecutor buildThreadPool() {
        ThreadFactory threadFactory = (new ThreadFactoryBuilder()).setNameFormat("demo-test-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS,
                                                                       new LinkedBlockingQueue(1000), threadFactory);

        //这里快速预热一下，让线程池充分初始化
        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    cpuRun(10);
                }
            });
        }
        return threadPoolExecutor;
    }

    public static YKThreadPoolExecutor buildMyPool() {
        ThreadFactory threadFactory = (new ThreadFactoryBuilder()).setNameFormat("demo-test-%d").build();
        YKThreadPoolExecutor threadPoolExecutor = new YKThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS,
                                                                           new LinkedBlockingQueue(1000),
                                                                           threadFactory);

        //这里快速预热一下，让线程池充分初始化
        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    cpuRun(10);
                }
            });
        }
        return threadPoolExecutor;
    }
}
