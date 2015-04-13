package com.hz.yk.yk.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * 尝试去中断一个LockSupport.unPark()
 * @author wuzheng.yk
 *         Date: 13-11-11
 *         Time: 下午9:09
 */
public class ParkTest {
    private static LockSupportTest blocker = new LockSupportTest();

    public static void main(String args[]) throws Exception {
        parkTest();
    }


    /**
     * 尝试去中断一个LockSupport.unPark()，会有响应
     *
     * @throws InterruptedException
     */
    private static void parkTest() throws InterruptedException {
        Thread t = ThreadFactory.createThread(new TestCallBack() {

            @Override
            public void callback() {
                // 尝试去park 自己线程
                LockSupport.park(blocker);
                System.out.println("wakeup now!");
            }

            @Override
            public String getName() {
                return "parkTest";
            }

        });

        t.start(); // 启动读取线程
        Thread.sleep(2000);
        LockSupport.unpark(t);
        t.interrupt();
    }

}
