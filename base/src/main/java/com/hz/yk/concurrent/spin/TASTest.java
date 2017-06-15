package com.hz.yk.concurrent.spin;

import org.junit.Test;

/**
 * 测试结果，单线程的执行效率最高，多线程的情况下导致执行效率变慢，我的电脑时4核的，
 * 可以见线程的上下文切换很需要时间，而且CPU容易飙升到100%，这种情况下反而优化后的锁更浪费时间，因为CPU耗尽的原因，
 * 所以实际工作中还是需要结合服务器去做测试。
 * 在测试过程中如果增大NTHREAD 的值，最后的count 可能大于MAX，估计是ABA 的问题
 * Created by wuzheng.yk on 17/3/21.
 */
public class TASTest {

    private LockBaseTest lockBaseTest = new LockBaseTest(new TASLock());
    //private LockBaseTest lockBaseTest = new LockBaseTest(new TTASLock());


    @Test
    public void testUnsafe() throws InterruptedException {
        lockBaseTest.testUnsafe();
    }

    @Test
    public void testSingleThread() throws InterruptedException {
        lockBaseTest.testSingleThread();

    }
}
