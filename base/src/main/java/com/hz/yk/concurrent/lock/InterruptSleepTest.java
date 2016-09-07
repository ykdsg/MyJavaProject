package com.hz.yk.concurrent.lock;

/**
 * ����ȥ�ж�һ��Thread.sleep()�����׳���Ӧ��InterruptedException�쳣
 * @author wuzheng.yk
 *         Date: 13-11-9
 *         Time: ����4:34
 */
public class InterruptSleepTest {

    private static LockSupportTest blocker = new LockSupportTest();

    public static void main(String args[]) throws Exception {
        interruptSleepTest();
    }

    /**
     * ����ȥ�ж�һ��Thread.sleep()�����׳���Ӧ��InterruptedException�쳣
     *
     * @throws InterruptedException
     */
    private static void interruptSleepTest() throws InterruptedException {
        Thread t = ThreadFactory.createThread(new TestCallBack() {

            @Override
            public void callback() throws Exception {
                // ����sleep 5s
                Thread.sleep(5000);
                System.out.println("wakeup now!");
            }

            @Override
            public String getName() {
                return "interruptSleepTest";
            }

        });
        t.start(); // ������ȡ�߳�
        Thread.sleep(2000);
        t.interrupt(); // �������parkʱ���Ƿ���Ӧ�ж�
    }
}
