package com.hz.yk.concurrent.lock;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 公平重入锁
 * 来的请求线程放到列表中，然后 notify的时候调用列表第一个的notify，即通知唤醒先来的请求线程即可
 * Created by wuzheng.yk on 2017/5/16.
 */
public class FairReetrantLockTest {
    private int count = 0;

    @Test
    public void testUnsafe() {
        CountDownLatch latch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            Worker worker = new Worker(latch, i);
            worker.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    FairLock fairLock = new FairLock();
    public int fairLockInc() {
        int newCount = count;
        try {
            fairLock.lock();
            newCount = ++count;

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            fairLock.unlock();
        }

        return newCount;
    }

    class Worker extends Thread {
        private CountDownLatch latch;
        public Worker(CountDownLatch latch, int i) {
            this.latch = latch;
            this.setName(i + " thread");
        }
        public void run() {
            try {
                fairLockInc();
            } catch (Exception e) {
                e.printStackTrace();
            }
            latch.countDown();
        }
    }

    class FairLock {
        private boolean isLocked = false;
        private Thread lockingThread = null;
        private List<QueueObject> waitingThreads = new ArrayList<QueueObject>();

        public void lock() throws InterruptedException {
            QueueObject queueObject = new QueueObject();
            boolean isLockedForThisThread = true;
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " in");
                waitingThreads.add(queueObject);
            }

            while (isLockedForThisThread) {
                synchronized (this) {
                    isLockedForThisThread = isLocked || waitingThreads.get(0) != queueObject;
                    if (!isLockedForThisThread) {
                        isLocked = true;
                        System.out.println(Thread.currentThread().getName()
                                + " out");
                        waitingThreads.remove(queueObject);
                        lockingThread = Thread.currentThread();
                        return;
                    }
                }
                try {
                    queueObject.doWait();
                } catch (InterruptedException e) {
                    synchronized (this) {
                        System.out.println(Thread.currentThread().getName()
                                + " out");
                        waitingThreads.remove(queueObject);
                    }
                    throw e;
                }
            }
        }

        public synchronized void unlock() {
            if (this.lockingThread != Thread.currentThread()) {
                throw new IllegalMonitorStateException(
                        "Calling thread has not locked this lock");
            }
            isLocked = false;
            lockingThread = null;
            if (waitingThreads.size() > 0) {
                waitingThreads.get(0).doNotify();
            }
        }
    }
    class QueueObject {

        private boolean isNotified = false;

        public synchronized void doWait() throws InterruptedException {

            while (!isNotified) {
                this.wait();
            }

            this.isNotified = false;
        }

        public synchronized void doNotify() {
            this.isNotified = true;
            this.notify();
        }

        public boolean equals(Object o) {
            return this == o;
        }

    }
}
