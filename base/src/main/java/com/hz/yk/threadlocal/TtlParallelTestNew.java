package com.hz.yk.threadlocal;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.yt.asd.kit.pressure.PressureContext;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author wuzheng.yk
 * @date 2021/5/11
 */
public class TtlParallelTestNew {

    /**
     * 不加agent的时候可以看到，子线程拿不到父线程ThreadLocal中的值。
     * 加了ttl agent（-javaagent:/Users/ykdsg/.m2/repository/com/hipac/transmittable-thread-local/2.11.8/transmittable-thread-local-2.11.8.jar），子线程可以拿到父线程的值了。但是子线程中执行并行流的的线程，参与了异步任务的执行（notEmpty的异步过滤），这个异步任务又是会被TTL压测标增强，那么执行了这个增强后的notEmpty后，压测标会被清理
     *
     * @throws InterruptedException
     */
    @Test
    public void testParallel() throws InterruptedException {
        ThreadPoolExecutor tp = buildThreadPool();
        tp.prestartAllCoreThreads();

        PressureContext.setPressure("pressure_flag");
        System.out.println("outer - " + PressureContext.getPressure());
        tp.execute(() -> {
            System.out.println("inner a - " + PressureContext.getPressure());
           assertNotNull(PressureContext.getPressure());
            List<String> ls = Lists.newArrayList("1", "2").parallelStream().filter(s -> notEmpty(s))
                    .collect(Collectors.toList());
            System.out.println("inner b - " + PressureContext.getPressure());
        });
        Thread.sleep(2000);
    }

    private static boolean notEmpty(String s) {
        String cn = Thread.currentThread().getName();
        System.out.println(cn);
        return false;
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
}
