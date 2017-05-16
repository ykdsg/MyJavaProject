package com.hz.yk.concurrent.lock;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * 非公平重入锁
 * Created by wuzheng.yk on 2017/5/16.
 */
public class ReetrantLockTest {

    private int count = 0;

    @Test
    public void testUnsafe() {
        CountDownLatch latch=new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            Worker worker  = new Worker(latch);
            worker.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public int inc(){
        synchronized(this){
            System.out.println(count);
            return ++count;

        }
    }

    private Lock lock = new Lock();
    public int lockInc() {
        int newCount=count;
        try {
            lock.lock();
            newCount = ++count;
            System.out.println(count);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return newCount;
    }
    public class Lock{
        private boolean isLocked = false;

        public synchronized void lock()
                throws InterruptedException{
            while(isLocked){

//            if(isLocked){

                wait();
            }
            isLocked = true;
        }

        public synchronized void unlock(){
            isLocked = false;
            notify();
        }
    }
    class Worker extends Thread {
        private CountDownLatch latch;
        public Worker(CountDownLatch latch) {
            this.latch = latch;
        }
        public void run() {
//            inc();
//            lockInc();
            try {
//                reentrantOuter();//可重入 synchronized方式
//                unReentrantOuter(); //lock未处理是否自己锁 产生的是不可重入锁，导致死锁
                reentrantLockOuter();//lock方式实现可重入锁
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            latch.countDown();
        }
    }


    /**
     *
     * 可重入锁的测试
     */
    @Test
    public void testReentrant() {
        CountDownLatch latch=new CountDownLatch(2);
        for (int i = 0; i < 2; i++) {
            Worker worker  = new Worker(latch);
            worker.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public synchronized void reentrantOuter() throws InterruptedException{
        System.out.println("reentrantOuter1");
        reentrantInner();
    }

    public synchronized void reentrantInner() throws InterruptedException{
        Thread.currentThread().sleep(10);
        System.out.println("reentrantInner2");
    }


    public void unReentrantOuter() throws InterruptedException{
        try {
            lock.lock();
            System.out.println("unReentrantouter1");
            unReentrantInner();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void unReentrantInner() {
        try {
            lock.lock();
            System.out.println("unReentrantInner2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void reentrantLockOuter() {
        try {
            reentrantLock.lock();
            System.out.println("unReentrantouter1");
            reentrantLockInner();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public synchronized void reentrantLockInner() throws InterruptedException{
        try {
            reentrantLock.lock();
            System.out.println("unReentrantInner2");
            Thread.currentThread().sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    ReentrantLock reentrantLock = new ReentrantLock();
    class ReentrantLock{
        boolean isLocked = false;
        Thread  lockedBy = null;
        int lockedCount = 0;

        public synchronized void lock()
                throws InterruptedException{
            Thread callingThread = Thread.currentThread();
            while(isLocked && lockedBy != callingThread){
                wait();
            }
            isLocked = true;
            lockedCount++;
            lockedBy = callingThread;
        }

        public synchronized void unlock(){
            if(Thread.currentThread() ==this.lockedBy){
                lockedCount--;
                if(lockedCount == 0){
                    isLocked = false;
                    notify();
                }
            }
        }
    }
}
