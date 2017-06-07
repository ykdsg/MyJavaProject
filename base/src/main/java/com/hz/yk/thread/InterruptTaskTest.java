package com.hz.yk.thread;

import org.junit.Test;

/**
 * Created by wuzheng.yk on 2017/5/23.
 */
public class InterruptTaskTest {

    /**
     * 调用interrupt()后，程序仍在运行,虽然中断发生了，但线程仍然在进行
     * 
     * @throws Exception
     */
    @Test
    public void testInterruptA() throws Exception {
        // 将任务交给一个线程执行
        Thread t = new Thread(new ATask());
        t.start();

        // 运行一断时间中断线程
        Thread.sleep(100);
        System.out.println("****************************");
        System.out.println("Interrupted Thread!");
        System.out.println("****************************");
        t.interrupt();
        Thread.currentThread().join();

    }

    @Test
    public void testInterruptB() throws Exception {
        // 将任务交给一个线程执行
        Thread t = new Thread(new BTask());
        t.start();

        // 运行一断时间中断线程
        Thread.sleep(100);
        System.out.println("****************************");
        System.out.println("Interrupted Thread!");
        System.out.println("****************************");
        t.interrupt();
        Thread.currentThread().join();

    }

    class ATask implements Runnable {

        private double d = 0.0;

        public void run() {
            // 死循环执行打印"I am running!" 和做消耗时间的浮点计算
            while (true) {
                System.out.println("I am running!");

                for (int i = 0; i < 900000; i++) {
                    d = d + (Math.PI + Math.E) / d;
                }
                // 给线程调度器可以切换到其它进程的信号
                Thread.yield();
            }
        }
    }

    /**
     * 在阻塞操作时如Thread.sleep()时被中断会抛出InterruptedException
     */
    class BTask implements Runnable {

        private double d = 0.0;

        public void run() {
            // 死循环执行打印"I am running!" 和做消耗时间的浮点计算
            try {
                while (true) {
                    System.out.println("I am running!");

                    for (int i = 0; i < 900000; i++) {
                        d = d + (Math.PI + Math.E) / d;
                    }
                    // 休眠一断时间,中断时会抛出InterruptedException
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                System.out.println("ATask.run() interrupted!");
            }
        }
    }

    /**
     * Thread.interrupted()检查是否发生中断.Thread.interrupted()能告诉你线程是否发生中断,并将清除中断状态标记，所以程序不会两次通知你线程发生了中断．
     */
    class CTask implements Runnable {

        private double d = 0.0;

        public void run() {

            // 检查程序是否发生中断
            while (!Thread.interrupted()) {
                System.out.println("I am running!");

                for (int i = 0; i < 900000; i++) {
                    d = d + (Math.PI + Math.E) / d;
                }
            }

            System.out.println("ATask.run() interrupted!");
        }
    }

    /**
     * 在point1之前处point2之后发生中断会产生两种不同的结果，可以通过修改InterruptTaskTest main()里的Thread.sleep()的时间来达到在point1之前产生中断或在point2之后产生中断.
     * 如果在point1之前发生中断，程序会在调用Thread.sleep()时抛出InterruptedException从而结束线程．这和在Thread.sleep()时被中断是一样的效果
     * 如果在point2之后发生中断，线程会继续执行到下一次while判断中断状态时
     */
    class DTask implements Runnable {

        private double d = 0.0;

        public void run() {

            try {
                // 检查程序是否发生中断
                while (!Thread.interrupted()) {
                    System.out.println("I am running!");
                    // point1 before sleep
                    Thread.sleep(20);
                    // point2 after sleep
                    System.out.println("Calculating");
                    for (int i = 0; i < 900000; i++) {
                        d = d + (Math.PI + Math.E) / d;
                    }
                }

            } catch (InterruptedException e) {
                System.out.println("Exiting by Exception");
            }

            System.out.println("ATask.run() interrupted!");
        }
    }
}
