package com.hz.yk.concurrent.aqs;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @author wuzheng.yk
 *         Date: 13-1-13
 *         Time: 下午8:49
 */
public class FIFOMutex {
    private AtomicBoolean locked = new AtomicBoolean(false);
    private Queue<Thread> waiters = new ConcurrentLinkedQueue<Thread>();


    public void lock() {
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        waiters.add(current);

        //如果waiters的第一个等待者不为当前线程，或者当前locked的状态为被占用(true)
        //那么park住当前线程
        System.out.println(Thread.currentThread() + ",locked=" + locked.get());
        while (waiters.peek() != current || !locked.compareAndSet(false, true)) {
            LockSupport.park();

            //当线程被unpark时，第一时间检查当前线程是否被interrupted
            if (Thread.interrupted()) {
                wasInterrupted = true;
            }
        }

        //得到锁后，从等待队列移除当前线程，如果，并且如果当前线程已经被interrupted，
        //那么再interrupt一下以便供外部响应。
        waiters.remove();
        if (wasInterrupted) {
            current.interrupt();
        }
    }

    //unlock逻辑相对简单，设定当前锁为空闲状态，并且将等待队列中
    //的第一个等待线程唤醒
    public void unlock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }

    public static void main(String[] args) throws InterruptedException {
        final FIFOMutex fifoMutex = new FIFOMutex();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 running");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "thread1 lock..........");
                fifoMutex.lock();
                System.out.println(Thread.currentThread() + "thread1 unlock..........");
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 running");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "thread2 lock..........");
                fifoMutex.lock();
                System.out.println(Thread.currentThread() + "thread2 unlock..........");
            }
        });

        thread1.start();
        thread2.start();
        Thread.sleep(800);

    }
}
