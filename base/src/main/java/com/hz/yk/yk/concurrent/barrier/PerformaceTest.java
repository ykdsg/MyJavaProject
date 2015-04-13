package com.hz.yk.yk.concurrent.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wuzheng.yk
 *         Date: 13-11-8
 *         Time: обнГ4:33
 */
public class PerformaceTest {
    private int threadCount;
    private CyclicBarrier barrier;
    private int loopCount = 10;

    public PerformaceTest(int threadCount) {
        this.threadCount = threadCount;
        barrier = new CyclicBarrier(threadCount, new Runnable() {
            @Override
            public void run() {
                collectTestResult();
            }
        });
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread("test-thread" + i) {
                public void run() {
                    for (int j = 0; j < loopCount; j++) {
                        doTest();
                        try {
                            barrier.await();
                        } catch (InterruptedException e) {
                            return;
                        } catch (BrokenBarrierException e) {
                            return;
                        }
                    }
                }
            };

        }
    }

    private void doTest() { /* do xxx */ }

    private void collectTestResult() { /* do xxx */ }
}
