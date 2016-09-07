package com.hz.yk.concurrent.lock;

/**
 * @author wuzheng.yk
 *         Date: 13-11-12
 *         Time: ����8:59
 */
public class InterruptWaitTest {

    public static void main(String[] args) throws InterruptedException {
        interruptWaitTest();
    }



    /**
     * ����ȥ�ж�һ��object.wait()�����׳���Ӧ��InterruptedException�쳣
     *
     * @throws InterruptedException
     */
    private static void interruptWaitTest() throws InterruptedException {
        final Object obj = new Object();
        Thread t = ThreadFactory.createThread(new TestCallBack() {

            @Override
            public void callback() throws Exception {
                // ����sleep 5s
                obj.wait();
                System.out.println("wakeup now!");
            }

            @Override
            public String getName() {
                return "interruptWaitTest";
            }

        });
        t.start(); // ������ȡ�߳�
        Thread.sleep(2000);
        t.interrupt();
    }
}
