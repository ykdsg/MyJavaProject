package com.hz.yk.thread.state;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * https://blog.csdn.net/u011024652/article/details/51584527
 *
 * @author wuzheng.yk
 * @date 2020/4/1
 */
public class StopThread {

    static class YieldRunnable implements Runnable {

        public volatile boolean isRunning = true;

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + "开始执行！");

            while (isRunning) {
                for (int i = 1; i < 6; i++) {
                    System.out.println(name + "执行了[" + i + "]次");
                    //注意，yield是静态方法
                    Thread.yield();
                }
            }

            System.out.println(name + "执行结束！");
        }
    }

    static class YieldRunnable2 implements Runnable {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + "开始执行！");

            while (!Thread.currentThread().isInterrupted()) {
                for (int i = 1; i < 6; i++) {
                    System.out.println(name + "执行了[" + i + "]次");
                    //注意，yield是静态方法
                    Thread.yield();
                }
                long time = System.currentTimeMillis();
                while (System.currentTimeMillis() - time < 1000) {
                    /*
                     * 使用while循环模拟 sleep 方法，这里不要使用sleep，具体原因下面再说
                     * 当线程调用了interrupt()方法后，如果线程在调用 Object 类的 wait()、wait(long) 或 wait(long, int) 方法，或者该类的 join()、join(long)、join(long, int)、sleep(long) 或 sleep(long, int) 方法过程中受阻，则其中断状态将被清除，它还将收到一个 InterruptedException。也就是说线程不仅不会被中断，系统还会抛出一个异常
                     * 一种可行的方法是在sleep()方法抛出异常时，在处理异常的时候再调用interrupt()方法将线程中止
                     */
                }
            }
            System.out.println(name + "执行结束！");
        }
    }

    @Test
    public void testStop() {
        System.out.println("主线程开始执行！");
        YieldRunnable runnable = new YieldRunnable();
        Thread thread = new Thread(runnable, "线程1");

        thread.start();
        sleep(1000);
        thread.stop();
        sleep(1000);

        //在调用了stop方法之后，线程中的循环语句还没有执行结束线程就戛然而止了
        assertThat(thread.getState()).isEqualTo(Thread.State.TERMINATED);
        System.out.println("主线程执行结束！");
    }

    @Test
    public void testSignal() {
        System.out.println("主线程开始执行！");
        YieldRunnable runnable = new YieldRunnable();
        Thread thread = new Thread(runnable, "线程1");

        thread.start();
        sleep(1000);
        runnable.isRunning = false;
        sleep(1000);
        //子线程正确执行了所有的循环，并打印退出信息正确退出了
        assertThat(thread.getState()).isEqualTo(Thread.State.TERMINATED);
        System.out.println("主线程执行结束！");
    }

    @Test
    public void testInterrupt() {
        System.out.println("主线程开始执行！");
        YieldRunnable runnable = new YieldRunnable();
        Thread thread = new Thread(runnable, "线程1");

        thread.start();
        sleep(1000);
        thread.interrupt();
        sleep(1000);
        //直接调用interrupt没有任何影响，线程状态还是runnable
        assertThat(thread.getState()).isEqualTo(Thread.State.TERMINATED);
        System.out.println("主线程执行结束！");
    }

    @Test
    public void testInterrupt2() {
        System.out.println("主线程开始执行！");
        YieldRunnable2 runnable = new YieldRunnable2();
        Thread thread = new Thread(runnable, "线程1");

        thread.start();
        sleep(1000);
        thread.interrupt();
        sleep(1000);
        //通过判断 isInterrupted 进行中断
        assertTrue(thread.isInterrupted());
        System.out.println("主线程执行结束！");
    }

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
