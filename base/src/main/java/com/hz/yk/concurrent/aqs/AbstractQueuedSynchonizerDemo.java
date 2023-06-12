package com.hz.yk.concurrent.aqs;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wuzheng.yk on 2017/5/17.
 */
public class AbstractQueuedSynchonizerDemo {

    class MyThread extends Thread {

        private Lock lock;

        public MyThread(String name, Lock lock){
            super(name);
            this.lock = lock;
        }

        public void run() {
            lock.lock();
            System.out.println(Thread.currentThread() +"after lock");
            try {
                Thread.sleep(50000);
                System.out.println(Thread.currentThread() + " running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread() +"after unlock");
            }
        }
    }

    @Test
    public void test1() throws InterruptedException {
        Lock lock = new ReentrantLock();

        MyThread t1 = new MyThread("t1", lock);
        MyThread t2 = new MyThread("t2", lock);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
