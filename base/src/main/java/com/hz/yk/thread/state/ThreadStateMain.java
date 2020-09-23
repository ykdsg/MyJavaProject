package com.hz.yk.thread.state;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * http://www.jiacheo.org/blog/338
 *
 * @author wuzheng.yk
 * @date 2018/8/28
 */
@SuppressWarnings("AlibabaAvoidManuallyCreateThread")
public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {
        //threadPoolBusy();
        //runnableInBlockedIO();
        runnableInBlockedSocket();
    }

    private static void NEW() {
        Thread t = new Thread();
        System.out.println(t.getState());
    }

    private static void RUNNABLE() throws InterruptedException {
        Thread t = new Thread() {

            @Override
            public void run() {
                cpuRun(20000);
            }

        };

        t.start();
        System.out.println(t.getState());
        t.join();

    }

    /**
     * 在io 阻塞读的时候线程状态也是runnable的。
     *
     * @throws InterruptedException
     */
    private static void runnableInBlockedIO() throws InterruptedException {
        Scanner in = new Scanner(System.in);

        Thread t1 = new Thread("demo-t1") {

            @Override
            public void run() {
                try {
                    System.out.println("start io read---------");
                    // 命令行中的阻塞读
                    String input = in.nextLine();
                    System.out.println(input);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    IOUtils.closeQuietly(in);
                }
            }
        };
        t1.start();

        t1.join();
    }

    /**
     * 在等待网络连接的时候，也是runnable
     *
     * @throws InterruptedException
     */
    private static void runnableInBlockedSocket() throws InterruptedException {
        Thread serverThread = new Thread(new Runnable() {

            @Override
            public void run() {
                ServerSocket serverSocket = null;
                try {
                    serverSocket = new ServerSocket(10086);
                    while (true) {
                        System.out.println("start socket accept");
                        // 阻塞的accept方法
                        Socket socket = serverSocket.accept();
                        System.out.println("end socket accept");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "demo-in-socket"); // 线程的名字
        serverThread.start();
        serverThread.join();
    }

    /**
     * 其中一个线程是runnable，另一个线程是Blocked，
     * jstack文件中显示的是waiting for monitor entry
     * 在ibm的jca工具中显示为waiting on monitor ，跟堆栈信息中不太一样，
     */
    private static void BLOCKED() {

        final Object lock = new Object();

        Runnable run = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {

                    synchronized (lock) {
                        cpuRun(500);
                        System.out.println(i);
                    }

                }
            }
        };

        Thread t1 = new Thread(run);
        t1.setName("t1");
        Thread t2 = new Thread(run);
        t2.setName("t2");

        t1.start();
        t2.start();

    }

    /**
     * 显示，waiting on condition ，Thread.State: TIMED_WAITING (sleeping)，
     * jca显示：Waiting on condition
     */
    private static void SLEEP() {
        Thread t1 = new Thread("t1") {

            @Override
            public void run() {
                try {
                    Thread.sleep(200000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        t1.start();
    }

    /**
     * t1 在wait的时候显示 WAITING (on object monitor)，
     * jca 中表示的状态是Object.wait()
     */
    private static void WAITING() {

        final Object lock = new Object();
        Thread t1 = new Thread() {

            @Override
            public void run() {

                int i = 0;

                while (true) {
                    synchronized (lock) {
                        System.out.println("t1 running");
                        cpuRun(2000);
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                        }
                        System.out.println(i++);
                        System.out.println("t1 end");

                    }
                }
            }
        };

        Thread t2 = new Thread() {

            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        System.out.println("t2 running");
                        cpuRun(5000);
                        lock.notifyAll();
                        System.out.println("t2 end");
                    }
                    //这里需要一定时间执行，否则t1 可能一直抢不到锁
                    cpuRun(100);
                }
            }
        };

        t1.setName("^^t1^^");
        t2.setName("^^t2^^");

        t1.start();
        t2.start();
    }

    /**
     * 模拟线程池处理空闲的情况
     * 线程池空闲线程的状态：waiting on condition，java.lang.Thread.State: WAITING (parking)
     * jca显示：Waiting on condition
     *
     * @throws InterruptedException
     */
    private static void threadPoolFree() throws InterruptedException {
        System.out.println("all start");
        ThreadPoolExecutor threadPoolExecutor = buildThreadPool();

        Thread.sleep(3000);
        System.out.println("warmup end,start 1 runnable");
        threadPoolExecutor.execute(new Runnable() {

            @Override
            public void run() {
                cpuRun(500000);
                System.out.println("last thread over");
            }
        });
        System.out.println("all end");
    }

    /**
     * 模拟线程池繁忙的情况
     *
     * @throws InterruptedException
     */
    private static void threadPoolBusy() throws InterruptedException {
        System.out.println("all start");
        final ThreadPoolExecutor threadPoolExecutor = buildThreadPool();
        Thread.sleep(2000);
        System.out.println("warmup end,start runnable");
        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    final Random random = new Random();
                    final int duration = random.nextInt(100) + 3000;
                    cpuRun(duration);
                    System.out.println(Thread.currentThread() + " over");
                }
            });
        }
        System.out.println("all end");
    }

    private static ThreadPoolExecutor buildThreadPool() {
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
    private static void cpuRun(long duration) {

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
