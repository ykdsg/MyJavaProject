package com.hz.yk.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author wuzheng.yk
 * @date 2020/6/6
 */
public class CompleteDemo {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("师傅准备做蛋糕");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("师傅做蛋糕做好了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "cake";
        }).thenAccept(cake -> {
            System.out.println("我吃蛋糕:" + cake);
        });
        System.out.println("我先去喝杯牛奶");
        Thread.currentThread().join();
    }

}
