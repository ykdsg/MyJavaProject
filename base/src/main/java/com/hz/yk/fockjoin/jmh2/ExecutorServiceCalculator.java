package com.hz.yk.fockjoin.jmh2;

import com.hz.yk.fockjoin.jmh2.task.SleepTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author wuzheng.yk
 * @date 2020/5/22
 */
public class ExecutorServiceCalculator implements Calculator {

    private ExecutorService pool;

    public ExecutorServiceCalculator(ExecutorService pool) {
        this.pool = pool;
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

}
