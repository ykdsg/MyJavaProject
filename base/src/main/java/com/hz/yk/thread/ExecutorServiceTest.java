package com.hz.yk.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by wuzheng.yk on 2017/7/26.
 */
public class ExecutorServiceTest {

    @Test public void testExecutorService() throws ExecutionException, InterruptedException {
        // 一个有7个作业线程的线程池，老大的老大找到一个管7个人的小团队的老大
        ExecutorService laodaA = Executors.newFixedThreadPool(7);
        //提交作业给老大，作业内容封装在Callable中，约定好了输出的类型是String。
        String outputs = laodaA.submit(new Callable<String>() {

            public String call() throws Exception {
                Thread.sleep(2000);
                return "I am a task, which submited by the so called laoda, and run by those anonymous workers";
            }
            //提交后就等着结果吧，到底是手下7个作业中谁领到任务了，老大是不关心的。
        }).get();

        System.out.println(outputs);
    }

    @Test public void test01() throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(2, new ThreadFactoryBuilder().setNameFormat(
                "thread-call-runner-%d").build());
        final LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<String>();
        for (int i = 1; i <= 10; i++) {
            deque.add(i + "");
        }
        Future<?> submit1 = es.submit(new Runnable() {

            @Override public void run() {
                while (!deque.isEmpty()) {
                    System.out.println(deque.poll() + "-" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        Future<?> submit2 = es.submit(new Runnable() {

            @Override public void run() {
                while (!deque.isEmpty()) {
                    System.out.println(deque.poll() + "-" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        submit1.get();
    }

    /**
     * Future的cancel方法的使用
     *
     * @throws Exception
     */
    @Test public void test03() throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(2, new ThreadFactoryBuilder().setNameFormat(
                "thread-call-runner-%d").build());
        final LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<String>();
        for (int i = 1; i <= 5000; i++) {
            deque.add(i + "");
        }
        Future<String> result = es.submit(new Callable<String>() {

            @Override public String call() throws Exception {
                while (!deque.isEmpty() && !Thread.currentThread().isInterrupted()) {
                    System.out.println(deque.poll() + "-" + Thread.currentThread().getName());
                }
                return "done";
            }
        });

        try {
            System.out.println(result.get(10, TimeUnit.MILLISECONDS));
        } catch (TimeoutException e) {
            System.out.println("cancel result: " + result.cancel(true));
            System.out.println("is cancelled: " + result.isCancelled());
        }
        Thread.sleep(2000l);
    }

    @Test public void test04() throws Exception {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2, new ThreadFactoryBuilder().setNameFormat(
                "thread-schedule-runner-%d").build());
        Future<String> result = ses.schedule(new Callable<String>() {

            @Override public String call() throws Exception {
                System.out.println("exec task");
                return "ok";
            }
        }, 10, TimeUnit.SECONDS);
        Thread.sleep(15000);
    }
}
