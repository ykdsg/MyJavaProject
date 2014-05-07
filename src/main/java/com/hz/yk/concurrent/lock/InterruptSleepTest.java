package com.hz.yk.concurrent.lock;

/**
 * 尝试去中断一个Thread.sleep()，会抛出对应的InterruptedException异常
 * @author wuzheng.yk
 *         Date: 13-11-9
 *         Time: 下午4:34
 */
public class InterruptSleepTest {

    private static LockSupportTest blocker = new LockSupportTest();

    public static void main(String args[]) throws Exception {
        interruptSleepTest();
    }

    /**
     * 尝试去中断一个Thread.sleep()，会抛出对应的InterruptedException异常
     *
     * @throws InterruptedException
     */
    private static void interruptSleepTest() throws InterruptedException {
        Thread t = ThreadFactory.createThread(new TestCallBack() {

            @Override
            public void callback() throws Exception {
                // 尝试sleep 5s
                Thread.sleep(5000);
                System.out.println("wakeup now!");
            }

            @Override
            public String getName() {
                return "interruptSleepTest";
            }

        });
        t.start(); // 启动读取线程
        Thread.sleep(2000);
        t.interrupt(); // 检查下在park时，是否响应中断
    }
}
