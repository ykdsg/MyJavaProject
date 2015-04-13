package com.hz.yk.yk.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * 尝试去中断一个LockSupport.park(),会有响应但LockSupport.park不会抛出InterruptedException异常
 * @author wuzheng.yk
 *         Date: 13-11-9
 *         Time: 下午4:25
 */
public class InterruptParkTest {
    private static LockSupportTest blocker = new LockSupportTest();

    public static void main(String args[]) throws Exception {
        interruptParkTest();
    }


    /**
     * 尝试去中断一个LockSupport.park()，会有响应但不会抛出InterruptedException异常
     *
     * @throws InterruptedException
     */
    private static void interruptParkTest() throws InterruptedException {
        Thread t = ThreadFactory.createThread(new TestCallBack() {
            @Override
            public void callback() {
                // 尝试去park 自己线程
                LockSupport.park(blocker);
                System.out.println("wakeup now!");
            }

            @Override
            public String getName() {
                return "interruptParkTest";
            }

        });
        t.start(); // 启动读取线程
        Thread.sleep(2000);
        System.out.println("begin interrupt");
        t.interrupt(); // 检查下在park时，是否响应中断
    }
}
