package com.hz.yk.concurrent.spin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试结果，单线程的执行效率最高，多线程的情况下导致执行效率变慢，我的电脑时4核的，
 * 可以见线程的上下文切换很需要时间，而且CPU容易飙升到100%，这种情况下反而优化后的锁更浪费时间，因为CPU耗尽的原因，
 * 所以实际工作中还是需要结合服务器去做测试。
 * 在测试过程中如果增大NTHREAD 的值，最后的count 可能大于MAX，估计是ABA 的问题
 * Created by wuzheng.yk on 17/3/21.
 */
public class TASTest {

    // 并发线程数
    private final static int    NTHREAD = 10;
    // 计数
    private static volatile int count   = 0;
    // 最大计数
    private final static int    MAX     = 1000000;
    // TAS锁
     private static TASLock lock = new TASLock();

    // TTAS锁
    //private static TTASLock     lock    = new TTASLock();

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testUnsafe() throws InterruptedException {
        final CountDownLatch endGate = new CountDownLatch(NTHREAD);
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

    @Test
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
