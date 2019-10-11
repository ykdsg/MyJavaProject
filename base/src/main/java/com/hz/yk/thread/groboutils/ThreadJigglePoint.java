package com.hz.yk.thread.groboutils;

import java.util.Random;

/**
 * @author wuzheng.yk
 * @date 2019/10/7
 */
public class ThreadJigglePoint {

    private static Random random = new Random();

    public static void jiggle() throws InterruptedException {
        int i = random.nextInt(100);
        int mod = i % 3;
        Thread.currentThread().setPriority(i % 10 + 1);
        if (mod == 0) {
            if (i == 0) {
                return;
            }
            System.out.println("###############thread wait " + i);
            Object lockWait = new Object();
            synchronized (lockWait) {
                lockWait.wait(i);
            }
        }
        if (mod == 1) {
            System.out.println("###############thread yield ");

            Thread.yield();
        }
        if (mod == 2) {
            System.out.println("###############thread sleep ");
            Thread.sleep(20);
        }
    }
}
