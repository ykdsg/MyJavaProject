package com.hz.yk.concurrent.park;

import org.junit.Test;

/**
 * 实现两线程同步,使用wait/notify实现　
 * Created by wuzheng.yk on 2017/5/16.
 */
public class WaitAndNotifyDemo {


    /**
     * 使用wait/notify实现同步时，必须先调用wait，后调用notify，如果先调用notify，再调用wait，将起不了作用　
     * @throws InterruptedException
     */
    @Test
    public void testWaitBeforeNotify() throws InterruptedException {
        MyThread myThread = new MyThread();
        synchronized (myThread) {
            try {
                myThread.start();
                // 主线程睡眠3s
                Thread.sleep(3000);
                System.out.println("before wait");
                // 阻塞主线程
                myThread.wait();
                System.out.println("after wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 先调用notify，再调用wait，将起不了作用　
     * @throws InterruptedException
     */
    @Test
    public void testWaitAfterNotify() throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        // 主线程睡眠3s
        Thread.sleep(3000);
        synchronized (myThread) {
            try {
                System.out.println("before wait");
                // 阻塞主线程
                myThread.wait();
                System.out.println("after wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class MyThread extends Thread {

        public void run() {
            synchronized (this) {
                System.out.println("before notify");
                notify();
                System.out.println("after notify");
            }
        }
    }
}



