package com.hz.yk.yk.concurrent.lock;

import java.lang.reflect.Field;
import java.util.concurrent.locks.LockSupport;

/**
 * @author wuzheng.yk
 *         Date: 13-11-9
 *         Time: 下午3:54
 */
public class LockSupportTest {
    private static LockSupportTest blocker = new LockSupportTest();

    public static void main(String args[]) throws Exception {
        lockSupportTest();
    }

    /**
     * LockSupport.park对象后，尝试获取Thread.blocker对象，调用其single唤醒
     *
     * @throws Exception
     */
    private static void lockSupportTest() throws Exception {
        Thread t = ThreadFactory.createThread(new TestCallBack() {
            @Override
            public void callback() throws Exception {
                // 尝试sleep 5s
                System.out.println("blocker");
                LockSupport.park(blocker);
                System.out.println("wakeup now!");
            }

            @Override
            public String getName() {
                return "lockSupportTest";
            }

        });
        t.start(); // 启动读取线程

        Thread.sleep(150);
        synchronized (blocker) {
            Field field = Thread.class.getDeclaredField("parkBlocker");
            field.setAccessible(true);
            Object fBlocker = field.get(t);
            System.out.println(blocker == fBlocker);
            Thread.sleep(100);
            System.out.println("notifyAll");
            blocker.notifyAll();//object.notifyAll()不能唤醒LockSupport的阻塞Thread.
            //这句才能唤醒线程
//            LockSupport.unpark(t);
        }
    }

}
