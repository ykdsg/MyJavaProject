package com.hz.yk.fockjoin.jmh2;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author wuzheng.yk
 * @date 2020/6/16
 */
public class ReactorCalculator implements Calculator {

    /**
     * 线程池
     */
    private final Scheduler scheduler = Schedulers.elastic();

    @Override
    public long sumUp(long[] numbers) {
        List<Long> nums = new ArrayList<>(numbers.length);
        for (long number : numbers) {
            nums.add(number);
        }

        Flux<Long> longFlux = Flux.fromIterable(nums).flatMap(num -> Mono.fromCallable(() -> {
            try {
                Thread.sleep(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(Thread.currentThread());
            return num;
        }).subscribeOn(scheduler));
        Mono<Long> result = longFlux.reduce((a, b) -> a + b);

        return result.block();
    }

    public static void main(String[] args) {
        Random r = new Random();
        r.setSeed(0x32106234567L);
        long[] numbers = new long[80];

        long resultSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            //numbers[i] = r.nextInt(20);
            numbers[i] = 10;
            resultSum += numbers[i];
        }
        ReactorCalculator calculator = new ReactorCalculator();

        long start = System.currentTimeMillis();
        System.out.println("calc=" + calculator.sumUp(numbers));
        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start));
        System.out.println("sum=" + resultSum);

    }

    @Test
    public void testFlux() {
        List<Long> nums = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            nums.add((long) i);
        }

        //subscribeOn 的位置很重要，这个决定了Mono.fromCallable 是否能够并发执行
        Flux<Long> resultFlux = Flux.fromIterable(nums).flatMap(num -> Mono.fromCallable(() -> {
            Thread.sleep(10);
            System.out.println(Thread.currentThread());
            return num;
        }).subscribeOn(scheduler));
        resultFlux.blockLast();
    }
}
