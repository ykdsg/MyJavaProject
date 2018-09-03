package com.hz.yk.thread.state;

/**
 * http://www.jiacheo.org/blog/338
 *
 * @author wuzheng.yk
 * @date 2018/8/28
 */
public class ThreadStateMain {

    public static void main(String[] args) {
        BLOCKED();
    }

    private static void NEW() {
        Thread t = new Thread();
        System.out.println(t.getState());
    }

    private static void RUNNABLE() {
        Thread t = new Thread() {

            @Override
            public void run() {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    System.out.println(i);
                }
            }

        };

        t.start();
        System.out.println(t.getState());

    }

    private static void BLOCKED() {

        final Object lock = new Object();

        Runnable run = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {

                    synchronized (lock) {
                        System.out.println(i);
                    }

                }
            }
        };

        Thread t1 = new Thread(run);
        t1.setName("t1");
        Thread t2 = new Thread(run);
        t2.setName("t2");

        t1.start();
        t2.start();

    }

    private static void WAITING() {

        final Object lock = new Object();
        Thread t1 = new Thread() {

            @Override
            public void run() {

                int i = 0;

                while (true) {
                    synchronized (lock) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                        }
                        System.out.println(i++);
                    }
                }
            }
        };

        Thread t2 = new Thread() {

            @Override
            public void run() {

                while (true) {
                    synchronized (lock) {
                        for (int i = 0; i < 10000000; i++) {
                            System.out.println(i);
                        }
                        lock.notifyAll();
                    }

                }
            }
        };

        t1.setName("^^t1^^");
        t2.setName("^^t2^^");

        t1.start();
        t2.start();
    }
}
