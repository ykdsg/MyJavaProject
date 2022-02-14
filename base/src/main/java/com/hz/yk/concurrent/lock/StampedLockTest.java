package com.hz.yk.concurrent.lock;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

/**
 * @author wuzheng.yk
 * @date 2022/2/6
 */
@SuppressWarnings("AlibabaAvoidManuallyCreateThread")
public class StampedLockTest {

    /**
     * 使用 StampedLock 一定不要调用中断操作,中断线程t2，会导致t2 所在cpu 飙升。
     * 如果需要支持中断功能,一定使用可中断的悲观读锁 readLockInterruptibly() 和写锁 writeLockInterruptibly()
     */
    public static void main(String[] args) throws InterruptedException {
        StampedLock lock = new StampedLock();
        Thread t1 = new Thread(() -> {
            lock.writeLock();
            //lock.writeLockInterruptibly();
            System.out.println("t1 start park ");
            //阻塞在这里，不释放锁
            LockSupport.park();
        });
        t1.start();
        Thread.sleep(100);
        Thread t2 = new Thread(() -> {
            System.out.println("t2 readlock");
            lock.readLock();
            //lock.readLockInterruptibly();
        });
        t2.start();
        Thread.sleep(100);
        //中断线程t2，会导致t2 所在cpu 飙升。
        t2.interrupt();
        System.out.println("t2 interrupt");
        t2.join();

    }

    // StampedLock 标准用法
    static class Point {

        private int x, y;
        final StampedLock s1 = new StampedLock();

        //计算到原点的距离
        int distanceFromOrigin() {
            //乐观读
            long stamp = s1.tryOptimisticRead();
            int curX = x, curY = y;
            //判断读操作期间，是否存在写操作。
            if (!s1.validate(stamp)) {
                //升级为悲观读锁
                stamp = s1.readLock();
                try {
                    curX = x;
                    curY = y;
                } finally {
                    //释放悲观读锁
                    s1.unlockRead(stamp);
                }
            }
            return (int) Math.sqrt(curX * curX + curY * curY);
        }
    }

}
