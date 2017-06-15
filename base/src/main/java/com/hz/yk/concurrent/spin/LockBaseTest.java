package com.hz.yk.concurrent.spin;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wuzheng.yk on 2017/6/15.
 */
public class LockBaseTest {

    // 并发线程数
    private final static int    NTHREAD = 10;
    // 计数
    private static volatile int count   = 0;
    // 最大计数
    private final static int    MAX     = 10000;
    // TAS锁
    private SpinLock lock;


    public LockBaseTest(SpinLock lock) {
        this.lock = lock;
    }

    public void testUnsafe() throws InterruptedException {
        final CountDownLatch endGate = new CountDownLatch(1);
        final CountDownLatch startGate = new CountDownLatch(1);
        ExecutorService e = Executors.newFixedThreadPool(NTHREAD);
        for (int i = 0; i < NTHREAD; i++) {
            e.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        startGate.await();
                        while (true) {
                            lock.lock();
                            if (count < MAX) {
                                count++;
                                lock.unLock();
                                continue;
                            }
                            lock.unLock();
                            break;
                        }
                        endGate.countDown();
                    } catch (InterruptedException ignored) {
                    }

                }
            });
        }
        long start = System.currentTimeMillis();
        startGate.countDown();
        endGate.await();
        long end = System.currentTimeMillis();
        long time = end - start;
        e.shutdown();
        System.out.print(time + "----------" + count);
    }

    public void testSingleThread() throws InterruptedException {
        long start = System.currentTimeMillis();
        while (true) {
            lock.lock();
            if (count < MAX) {
                count++;
                lock.unLock();
                continue;
            }
            lock.unLock();
            break;
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.print(time + "----------" + count);
    }


}
