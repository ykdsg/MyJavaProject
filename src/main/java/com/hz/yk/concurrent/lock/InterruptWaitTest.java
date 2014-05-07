package com.hz.yk.concurrent.lock;

/**
 * @author wuzheng.yk
 *         Date: 13-11-12
 *         Time: 下午8:59
 */
public class InterruptWaitTest {

    public static void main(String[] args) throws InterruptedException {
        interruptWaitTest();
    }



    /**
     * 尝试去中断一个object.wait()，会抛出对应的InterruptedException异常
     *
     * @throws InterruptedException
     */
    private static void interruptWaitTest() throws InterruptedException {
        final Object obj = new Object();
        Thread t = ThreadFactory.createThread(new TestCallBack() {

            @Override
            public void callback() throws Exception {
                // 尝试sleep 5s
                obj.wait();
                System.out.println("wakeup now!");
            }

            @Override
            public String getName() {
                return "interruptWaitTest";
            }

        });
        t.start(); // 启动读取线程
        Thread.sleep(2000);
        t.interrupt();
    }
}
