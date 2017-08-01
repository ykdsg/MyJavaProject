package com.hz.yk.thread;

import java.util.Date;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier可以在构造时指定需要在屏障前执行await的个数，所有对await的调用都会等待，直到调用await的次数达到预定指，
 * 所有等待都会立即被唤醒
 * 从使用场景上来说，CyclicBarrier是让多个线程互相等待某一事件的发生，然后同时被唤醒。
 * 而CountDownLatch是让某一线程等待多个线程的状态，然后该线程被唤醒
 * Created by wuzheng.yk on 2017/7/31.
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int totalThread = 5;
        CyclicBarrier barrier = new CyclicBarrier(totalThread);

        for(int i = 0; i < totalThread; i++) {
            String threadName = "Thread " + i;
            new Thread(() -> {
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, " is waiting"));
                try {
                    barrier.await();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, "ended"));
            }).start();
        }
    }
}
