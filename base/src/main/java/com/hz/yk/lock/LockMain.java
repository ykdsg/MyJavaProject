package com.hz.yk.lock;

/**
 * @author wuzheng.yk
 * @date 2020/8/7
 */
public class LockMain {
    //private static Lock lock = new ArrayLock(150);

    private static Lock lock = new CLHLock();

    //private static TimeCost timeCost = new TimeCost(new TTASLock());

    private static volatile int value = 0;

    public static void method() {
        lock.lock();
        System.out.println("Value: " + ++value);
        lock.unlock();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    method();
                }

            });
            t.start();
        }
    }
}
