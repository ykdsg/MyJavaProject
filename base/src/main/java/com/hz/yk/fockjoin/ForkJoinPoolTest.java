package com.hz.yk.fockjoin;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by wuzheng.yk on 2017/6/28.
 */
public class ForkJoinPoolTest {

    @Test public void testPrint() throws Exception {
        // 创建包含Runtime.getRuntime().availableProcessors()返回值作为个数的并行线程的ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 提交可分解的PrintTask任务
        forkJoinPool.submit(new PrintTask(0, 200));
        forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);// 阻塞当前线程直到 ForkJoinPool 中所有的任务都执行结束
        // 关闭线程池
        forkJoinPool.shutdown();
    }


    @Test public void testSum() throws ExecutionException, InterruptedException {
        int arr[] = new int[1000000];
        Random random = new Random();
        int total = 0;
        // 初始化100个数字元素
        for (int i = 0; i < arr.length; i++) {
            //int temp = random.nextInt(100);
            int temp = i;
            // 对数组元素赋值,并将数组元素的值添加到total总和中
            total += (arr[i] = temp);
        }
        System.out.println("初始化时的总和=" + total);
        // 创建包含Runtime.getRuntime().availableProcessors()返回值作为个数的并行线程的ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long start = System.currentTimeMillis();
        // 提交可分解的PrintTask任务
        //Future<Integer> future = forkJoinPool.submit(new SumTask(arr, 0, arr.length));
        Future<Integer> future = forkJoinPool.submit(new SumTask2(arr, 0, arr.length));
        System.out.println("计算出来的总和=" + future.get());
        int sum = future.get();
        Assert.assertEquals(total, sum);
        // 关闭线程池
        forkJoinPool.shutdown();
        System.out.println("cost :" + (System.currentTimeMillis() - start));
    }

    @Test public void testMix() throws ExecutionException, InterruptedException {
        // 创建包含Runtime.getRuntime().availableProcessors()返回值作为个数的并行线程的ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool(5);
        // 提交可分解的PrintTask任务
        //forkJoinPool.invoke(new PrintTask(0, 2000));

        int arr[] = new int[10000];
        Random random = new Random();
        int total = 0;
        // 初始化100个数字元素
        for (int i = 0; i < arr.length; i++) {
            int temp = random.nextInt(100);
            // 对数组元素赋值,并将数组元素的值添加到total总和中
            total += (arr[i] = temp);
        }
        System.out.println("初始化时的总和=" + total);
        // 创建包含Runtime.getRuntime().availableProcessors()返回值作为个数的并行线程的ForkJoinPool
        // 提交可分解的PrintTask任务
        //Future<Integer> future = forkJoinPool.submit(new SumTask(arr, 0, arr.length));
        //System.out.println("计算出来的总和=" + future.get());
        //int sum = future.get();
        int sum = forkJoinPool.invoke(new SumTask(arr, 0, arr.length));
        Assert.assertEquals(total, sum);
    }

}
