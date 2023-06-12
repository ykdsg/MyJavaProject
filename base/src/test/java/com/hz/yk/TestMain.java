package com.hz.yk;

import org.junit.jupiter.api.Test;

/**
 * Created by wuzheng.yk on 17/5/8.
 */
public class TestMain {

    @Test
    public void testMainThread() {
        Thread thread = new Thread(new TestThread());

        thread.start();
        System.out.println("main thread is done");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new TestThread());

        thread.start();
        System.out.println("main thread is done");

    }


    static class TestThread implements Runnable {
        @Override
        public void run() {
            System.out.println("test thread is running");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test thread is end");

        }
    }
}

