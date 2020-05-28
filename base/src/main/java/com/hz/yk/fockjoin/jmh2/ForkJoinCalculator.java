package com.hz.yk.fockjoin.jmh2;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author wuzheng.yk
 * @date 2020/5/22
 */
public class ForkJoinCalculator implements Calculator {

    private ForkJoinPool pool;

    public ForkJoinCalculator(ForkJoinPool pool) {
        // 也可以使用公用的线程池 ForkJoinPool.commonPool()：
        //pool = ForkJoinPool.commonPool();
        //pool = new ForkJoinPool();
        this.pool = pool;
    }

    @Override
    public long sumUp(long[] numbers) {
        Long result = pool.invoke(new SumTask(numbers, 0, numbers.length - 1));
        return result;
    }

    //执行任务RecursiveTask：有返回值  RecursiveAction：无返回值
    private static class SumTask extends RecursiveTask<Long> {

        Random random = new Random();

        private long[] numbers;
        private int from;
        private int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        //此方法为ForkJoin的核心方法：对任务进行拆分  拆分的好坏决定了效率的高低
        @Override
        protected Long compute() {

            // 当需要计算的数字个数小于3时，直接采用for loop方式计算结果
            if (to - from < 3) {
                long total = 0;
                for (int i = from; i <= to; i++) {
                    try {
                        Thread.sleep(random.nextInt(20));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    total += numbers[i];
                }
                return total;
            } else { // 否则，把任务一分为二，递归拆分(注意此处有递归)到底拆分成多少分 需要根据具体情况而定
                int middle = (from + to) / 2;
                SumTask taskLeft = new SumTask(numbers, from, middle);
                SumTask taskRight = new SumTask(numbers, middle + 1, to);
                taskLeft.fork();
                taskRight.fork();
                return taskLeft.join() + taskRight.join();
            }
        }
    }
}
