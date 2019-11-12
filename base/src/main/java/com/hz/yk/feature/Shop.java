package com.hz.yk.feature;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static java.util.stream.Collectors.toList;

/**
 * @author wuzheng.yk
 * @date 2019/11/8
 */
public class Shop {

    private String name;

    public Shop(String name) {
        this.name = name;
    }

    List<Shop> shops = Arrays.asList(new Shop("BestPrice"),

                                     new Shop("LetsSaveBig"), new Shop("MyFavoriteShop"), new Shop("BuyItAll"));

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public List<String> findPrices(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream().map(shop -> CompletableFuture
                .supplyAsync(() -> shop.getName() + " price is " + shop.getPrice(product))).collect(toList());

        return priceFutures.stream().map(CompletableFuture::join).collect(toList());

    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {

            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception e) {
                //抛出导致失败的异常，完成这次future操作
                futurePrice.completeExceptionally(e);
            }
        }).start();
        return futurePrice;
    }

    //上面的方法可以简化为下面的工厂方法
    public Future<Double> getPriceAsync2(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return name;
    }
}
