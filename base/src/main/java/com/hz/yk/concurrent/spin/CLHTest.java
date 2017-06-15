package com.hz.yk.concurrent.spin;

import org.junit.Test;

/**
 * Created by wuzheng.yk on 2017/6/15.
 */
public class CLHTest{

    private LockBaseTest lockBaseTest = new LockBaseTest(new CLHLock());

    @Test
    public void testUnsafe() throws InterruptedException {
        lockBaseTest.testUnsafe();
    }

    @Test
    public void testSingleThread() throws InterruptedException {
        lockBaseTest.testSingleThread();
    }
}
