package com.hz.yk.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * ����ȥ�ж�һ��LockSupport.park(),������Ӧ��LockSupport.park�����׳�InterruptedException�쳣
 * @author wuzheng.yk
 *         Date: 13-11-9
 *         Time: ����4:25
 */
public class InterruptParkTest {
    private static LockSupportTest blocker = new LockSupportTest();

    public static void main(String args[]) throws Exception {
        interruptParkTest();
    }


    /**
     * ����ȥ�ж�һ��LockSupport.park()��������Ӧ�������׳�InterruptedException�쳣
     *
     * @throws InterruptedException
     */
    private static void interruptParkTest() throws InterruptedException {
        Thread t = ThreadFactory.createThread(new TestCallBack() {
            @Override
            public void callback() {
                // ����ȥpark �Լ��߳�
                LockSupport.park(blocker);
                System.out.println("wakeup now!");
            }

            @Override
            public String getName() {
                return "interruptParkTest";
            }

        });
        t.start(); // ������ȡ�߳�
        Thread.sleep(2000);
        System.out.println("begin interrupt");
        t.interrupt(); // �������parkʱ���Ƿ���Ӧ�ж�
    }
}
