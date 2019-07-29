package com.hz.yk.reactor.price;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wuzheng.yk
 * @date 2019-06-26
 */
public class PriceMain {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 500; i++) {
            exec.execute(() -> {
                new PriceMaterialsMain().calcPriceSourceMaterials();
            });
        }
        Thread.currentThread().join();
    }

}
