package com.hz.yk.fockjoin.jmh2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author wuzheng.yk
 * @date 2020/5/22
 */
public class ExecutorServiceCalculator implements Calculator {

    private int parallism;
    private ExecutorService pool;

    public ExecutorServiceCalculator(ExecutorService pool, int parallism) {
        this.pool = pool;
        this.parallism = parallism;
    }

    @Override
    public long sumUp(long[] numbers) {
        List<Future<Long>> results = new ArrayList<>();

        for (long number : numbers) {
            results.add(pool.submit(new SleepTask(number)));
        }
        long total = 0L;
        for (Future<Long> f : results) {
            try {
                total += f.get();
            } catch (Exception ignore) {
            }
        }
        return total;
    }

    private static class SumTask implements Callable<Long> {

        private long[] numbers;
        private int from;
        private int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() {
            long total = 0;
            for (int i = from; i <= to; i++) {
                try {
                    Thread.sleep(numbers[i]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                total += numbers[i];
            }
            return total;
        }
    }

    private static class SleepTask implements Callable<Long> {

        private long number;

        public SleepTask(long number) {
            this.number = number;
        }

        @Override
        public Long call() throws Exception {
            try {
                Thread.sleep(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return number;
        }
    }
}
