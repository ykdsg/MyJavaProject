package com.hz.yk.lock;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wuzheng.yk on 15/8/1.
 */
public class LockTest {

    /**
     *  lock()忽视interrupt(), 拿不到锁就 一直阻塞
     * @throws InterruptedException
     */
    @Test
    public void testLock() throws InterruptedException {
        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        Thread.sleep(1000000);
    }

    /**
     * lockInterruptibly()会响应打扰 并catch到InterruptedException
     * @throws InterruptedException
     */
    @Test
    public void testLockInterruptibly() throws InterruptedException {
        final Lock lock=new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+" interrupted.");
                }
            }
        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        Thread.sleep(1000000);
    }


    /**
     * 当线程已经被打扰了（isInterrupted()返回true）。则线程使用lock.lockInterruptibly()，直接会被要求处理InterruptedException
     * @throws InterruptedException
     */
    @Test
    public void testLockInterruptibly2()throws InterruptedException {
        final Lock lock=new ReentrantLock();
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+" interrupted.");
                }
            }
        });
        t1.start();
        t1.interrupt();
        Thread.sleep(10000000);
    }


}
