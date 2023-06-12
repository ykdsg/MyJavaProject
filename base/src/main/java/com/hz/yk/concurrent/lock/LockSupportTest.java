package com.hz.yk.concurrent.lock;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by wuzheng.yk on 17/3/21.
 */
public class LockSupportTest {
    @Test
    public void testLockSupport() {
        LockSupport.park();
        System.out.println("block.");//阻塞在这里证明 默认许可时不可用的
    }
    @Test
    public void testUnpark() {
        Thread thread = Thread.currentThread();
        LockSupport.unpark(thread);//释放许可
        LockSupport.park();// 获取许可
        System.out.println("b");//正常执行 一对一使用
    }

    @Test
    public void testReentrantUnpark() {
        Thread thread = Thread.currentThread();

        LockSupport.unpark(thread);

        System.out.println("a");
        LockSupport.park();
        System.out.println("b");
        LockSupport.park();
        System.out.println("c");//阻塞在这里 ，说明非可重入的
    }
    @Test
    public void testInterrupt() throws Exception {
        Thread t = new Thread(new Runnable()
        {
            private int count = 0;

            @Override
            public void run()
            {
                long start = System.currentTimeMillis();
                long end = 0;

                while ((end - start) <= 1000)
                {
                    count++;
                    end = System.currentTimeMillis();
                }

                System.out.println("after 1 second.count=" + count);

                //等待或许许可
                LockSupport.park();
                System.out.println("thread over." + Thread.currentThread().isInterrupted());

            }
        });

        t.start();

        Thread.sleep(2000);

        // 中断线程
        t.interrupt(); //不会抛出InterruptException 不影响主线程

        Thread.sleep(1000);

        System.out.println("main over");
    }
}
