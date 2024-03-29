package com.hz.yk.threadlocal;

import com.hipac.ttl.TransmittableThreadLocal;
import com.hipac.ttl.threadpool.TtlExecutors;
import com.yt.asd.kit.pressure.PressureContext;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

import static com.hz.yk.thread.RunnableUtils.buildThreadPool;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * TTL 是用来解决 ITL 解决不了的问题而诞生的，所以 TTL 一定是支持父线程的本地变量传递给子线程这种基本操作的，ITL 也可以做到，但是前面有讲过，ITL 在线程池的模式下，就没办法再正确传递了，所以 TTL 做出的改进就是即便是在线程池模式下，也可以很好的将父线程本地变量传递下去
 * https://www.cnblogs.com/hama1993/p/10409740.html
 *
 * @author wuzheng.yk
 * @date 2020/10/13
 */
@SuppressWarnings("AlibabaAvoidManuallyCreateThread")
public class TransmitThreadLocalTest {

    private static ExecutorService executorService = TtlExecutors
            .getTtlExecutorService(Executors.newFixedThreadPool(2));

    private static ThreadLocal tl = new TransmittableThreadLocal<>(); //这里采用TTL的实现

    public static void main2(String[] args) {
        String mainThreadName = "**********main**********";
        tl.set(1);
        executorService.execute(() -> {
            sleep(1L);
            System.out.println(String.format("本地变量改变之前(1), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName,
                                             Thread.currentThread().getName(), tl.get()));
        });
    }

    //@Test
    //public void testAsdParallel() throws Exception {
    //    AsdThreadPoolImpl tp = new AsdThreadPoolImpl();
    //    tp.setBeanName("TEST-POOL");
    //    tp.afterPropertiesSet();
    //
    //    PressureContext.setPressure("pressure_flag");
    //    System.out.println("outer - " + PressureContext.getPressure());
    //    tp.execute(() -> {
    //        System.out.println("inner a - " + PressureContext.getPressure());
    //        List<String> ls = Lists.newArrayList("1", "2").parallelStream().filter(s -> notEmpty(s))
    //                .collect(Collectors.toList());
    //        System.out.println("inner b - " + PressureContext.getPressure());
    //    });
    //    Thread.sleep(2000);
    //}

    @Test
    //public static void main(String[] args) throws InterruptedException {
    public void testParallel() throws InterruptedException {
        //ThreadPoolExecutor tp = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS,
        //                                               new LinkedBlockingQueue(1000));
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

    public static void main1(String[] args) {

        new Thread(() -> {

            String mainThreadName = "main_01";

            tl.set(1);

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(1), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName,
                                                 Thread.currentThread().getName(), tl.get()));
            });

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(1), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName,
                                                 Thread.currentThread().getName(), tl.get()));
            });

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(1), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName,
                                                 Thread.currentThread().getName(), tl.get()));
            });

            sleep(1L); //确保上面的会在tl.set执行之前执行
            tl.set(2); // 等上面的线程池第一次启用完了，父线程再给自己赋值

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(2), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName,
                                                 Thread.currentThread().getName(), tl.get()));
            });

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(2), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName,
                                                 Thread.currentThread().getName(), tl.get()));
            });

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(2), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName,
                                                 Thread.currentThread().getName(), tl.get()));
            });

            System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));

        }).start();

        new Thread(() -> {

            String mainThreadName = "main_02";

            tl.set(3);

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(3), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName,
                                                 Thread.currentThread().getName(), tl.get()));
            });

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(3), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName,
                                                 Thread.currentThread().getName(), tl.get()));
            });

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(3), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName,
                                                 Thread.currentThread().getName(), tl.get()));
            });

            sleep(1L); //确保上面的会在tl.set执行之前执行
            tl.set(4); // 等上面的线程池第一次启用完了，父线程再给自己赋值

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(4), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName,
                                                 Thread.currentThread().getName(), tl.get()));
            });

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(4), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName,
                                                 Thread.currentThread().getName(), tl.get()));
            });

            executorService.execute(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(4), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName,
                                                 Thread.currentThread().getName(), tl.get()));
            });

            System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));

        }).start();

    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
