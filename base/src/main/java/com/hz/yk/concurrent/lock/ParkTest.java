package com.hz.yk.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * ����ȥ�ж�һ��LockSupport.unPark()
 * @author wuzheng.yk
 *         Date: 13-11-11
 *         Time: ����9:09
 */
public class ParkTest {
    private static LockSupportTest blocker = new LockSupportTest();

    public static void main(String args[]) throws Exception {
        parkTest();
    }


    /**
     * ����ȥ�ж�һ��LockSupport.unPark()��������Ӧ
     *
     * @throws InterruptedException
     */
    private static void parkTest() throws InterruptedException {
        Thread t = ThreadFactory.createThread(new TestCallBack() {

            @Override
            public void callback() {
                // ����ȥpark �Լ��߳�
                LockSupport.park(blocker);
                System.out.println("wakeup now!");
            }

            @Override
            public String getName() {
                return "parkTest";
            }

        });

        t.start(); // ������ȡ�߳�
        Thread.sleep(2000);
        LockSupport.unpark(t);
        t.interrupt();
    }

}
