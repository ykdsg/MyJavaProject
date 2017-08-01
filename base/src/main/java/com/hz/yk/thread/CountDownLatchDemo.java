package com.hz.yk.thread;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * 某个线程需要等待一个或多个线程操作结束（或达到某种状态）才开始执行。比如开发一个并发测试工具时，主线程需要等到所有测试线程均执行完成再开始统计总共耗费的时间
 * Created by wuzheng.yk on 2017/7/31.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int totalThread = 3;
        long start = System.currentTimeMillis();
        CountDownLatch countDown = new CountDownLatch(totalThread);
        for(int i = 0; i < totalThread; i++) {
            final String threadName = "Thread " + i;
            new Thread(() -> {
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, "started"));
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                //如果当前计数器的值大于1，则将其减1；若当前值为1，则将其置为0并唤醒所有通过await等待的线程；若当前值为0，则什么也不做直接返回。
                countDown.countDown();
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, "ended"));
            }).start();;
        }
        //等待计数器的值为0，若计数器的值为0则该方法返回；若等待期间该线程被中断，则抛出InterruptedException并清除该线程的中断状态
        countDown.await();
        long stop = System.currentTimeMillis();
        System.out.println(String.format("Total time : %sms", (stop - start)));
    }
}
