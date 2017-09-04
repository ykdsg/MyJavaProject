package com.hz.yk.rxjava;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wuzheng.yk on 2017/8/24.
 */
public class RxMetric {


    @Test
    public void testRxJavaWithBlocking1() throws Exception {
        int count = 100;
        CountDownLatch finishedLatch = new CountDownLatch(1);
        long t = System.nanoTime();
        Observable.range(0, count).map(i -> {
            //模拟30ms延迟
            Thread.sleep(30);
            System.out.println("B: " + Thread.currentThread().getName()+"i="+i);
            return 1;
        }).subscribe(statusCode -> {
        }, error -> {
        }, () -> {
            finishedLatch.countDown();
        });
        finishedLatch.await();
        t = (System.nanoTime() - t) / 1000000; //ms
        //tps只有28 ，接近单线程的执行效率
        System.out.println("RxJavaWithBlocking TPS: " + count * 1000 / t);
    }

    @Test
    public void testRxJavaWithBlocking2() throws Exception {
        int count = 100;
        CountDownLatch finishedLatch = new CountDownLatch(1);
        long t = System.nanoTime();
        Observable.range(0, count).map(i -> {
            //模拟30ms延迟
            Thread.sleep(30);
            System.out.println("B: " + Thread.currentThread().getName()+"i="+i);
            return 1;
        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.computation()).subscribe(statusCode -> {
        }, error -> {
        }, () -> {
            finishedLatch.countDown();
        });
        finishedLatch.await();
        t = (System.nanoTime() - t) / 1000000; //ms
        //tps只有28 ，接近单线程的执行效率，使用了调度器subscribeOn，observeOn 基本没变化
        System.out.println("RxJavaWithBlocking TPS: " + count * 1000 / t);
    }

    @Test
    public void testRxJavaWithFlatMap() throws InterruptedException {
        int count = 10000;
        ExecutorService es = Executors.newFixedThreadPool(1200, new ThreadFactoryBuilder().setNameFormat(
                "SubscribeOn-%d").build());
        //ExecutorService es = Executors.newWorkStealingPool(250);
        CountDownLatch finishedLatch = new CountDownLatch(1);
        long t = System.nanoTime();
        //通过flatmap可以将源Observable的元素项转成n个Observable,生成的每个Observable可以使用线程池并发的执行，同时flatmap还会将这n个Observable merge成一个Observable。
        Observable.range(0, count).subscribeOn(Schedulers.io()).flatMap(i -> {
            //System.out.println("A: " + Thread.currentThread().getName());
            return Observable.just(i).subscribeOn(Schedulers.from(es)).map(v -> {
                try {
                    //模拟30ms延迟
                    Thread.sleep(30);
                    System.out.println("B: " + Thread.currentThread().getName()+"i="+i);
                    return 1;
                } catch (Exception ex) {
                    return -1;
                }
            });
        }).observeOn(Schedulers.computation()).subscribe(statusCode -> {
            //System.out.println("C: " + Thread.currentThread().getName());
        }, error -> {
        }, () -> {
            finishedLatch.countDown();
        });
        finishedLatch.await();
        t = (System.nanoTime() - t) / 1000000; //ms
        //TPS 能到1w多
        System.out.println("RxJavaWithFlatMap TPS: " + count * 1000 / t);
        es.shutdownNow();
    }
}
