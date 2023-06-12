package com.hz.yk.concurrent.park;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by wuzheng.yk on 2017/5/16.
 */
public class ParkAndUnparkDemo {


    /**
     * 先执行park，然后在执行unpark，进行同步，并且在unpark的前后都调用了getBlocker，可以看到两次的结果不一样，并且第二次调用的结果为null，
     * 这是因为在调用unpark之后，执行了Lock.park(Object blocker)函数中的setBlocker(t, null)函数，所以第二次调用getBlocker时为null。
     */
    @Test
    public void test() {
        MyThread1 myThread = new MyThread1(Thread.currentThread());
        myThread.start();
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
        // 再次获取blocker
        System.out.println("Blocker info " + LockSupport.getBlocker(Thread.currentThread()));

    }

    /**
     * 先调用unpark，再调用park时，仍能够正确实现同步，不会造成由wait/notify调用顺序不当所引起的阻塞。因此park/unpark相比wait/notify更加的灵活。
     */
    @Test
    public  void test2() {
        MyThread2 myThread = new MyThread2(Thread.currentThread());
        myThread.start();
        try {
            // 主线程睡眠3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }

    class MyThread2 extends Thread {
        private Object object;

        public MyThread2(Object object) {
            this.object = object;
        }

        public void run() {
            System.out.println("before unpark");
            // 释放许可
            LockSupport.unpark((Thread) object);
            System.out.println("after unpark");
        }
    }
    class MyThread1 extends Thread {
        private Object object;

        public MyThread1(Object object) {
            this.object = object;
        }

        public void run() {
            System.out.println("before unpark");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 获取blocker
            System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));
            // 释放许可
            LockSupport.unpark((Thread) object);
            System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));
            System.out.println("after unpark");
        }
    }
}
