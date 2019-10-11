package com.hz.yk.thread.groboutils;

import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wuzheng.yk
 * @date 2019/10/7
 */
public class ParalIncTest2 {

    int tSize = 30;

    public static class Incrementor extends Thread {

        @Override
        public void run() {
        }
    }

    @Test
    public void testInc() throws Throwable {
        TestRunnable[] tcs = new TestRunnable[tSize];
        final ParalInc target = new ParalInc();

        for (int i = 0; i < tSize; i++) {

            TestRunnable r = new TestRunnable() {

                @Override
                public void runTest() throws Throwable {
                    //                synchronized(ParalIncTest.class) {
                    ThreadJigglePoint.jiggle();
                    target.i++;
                    ThreadJigglePoint.jiggle();

                    //                }
                }
            };
            tcs[i] = r;
        }
        int threadCount = tcs.length;

        MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(tcs);
        mttr.runTestRunnables(2 * 60 * 1000);
        System.out.println("final value: " + target.i);
        if (target.i != threadCount) {
            System.err.println("   Bug - at loop " + target.i);
        }
        assertEquals(threadCount, target.i);
    }

    static class ParalInc {

        public int i = 0;
    }
}
