package com.hz.yk.thread.state;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author wuzheng.yk
 * @date 2020/9/24
 */
public class ThreadStateDemo {

    public static void main(String[] args) throws InterruptedException {
        testLinkedBlockingQueue();
    }

    /**
     * waiting on condition
     * jca:Waiting on condition
     * at sun.misc.Unsafe.park(Native Method)
     * at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
     * at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
     * at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
     * at com.hz.yk.thread.state.ThreadStateDemo$1.run(ThreadStateDemo.java:22)
     *
     * @throws InterruptedException
     */
    public static void testLinkedBlockingQueue() throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue(2);
        final Thread thread = new Thread("test1") {

            @Override
            public void run() {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        System.out.println("after start:" + thread.getState());
        Thread.sleep(1000);
        System.out.println("after sleep:" + thread.getState());
    }

}
