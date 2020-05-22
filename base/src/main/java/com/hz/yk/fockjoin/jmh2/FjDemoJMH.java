package com.hz.yk.fockjoin.jmh2;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * 多线程和FJ的对比
 *
 * @author wuzheng.yk
 * @date 2020/5/22
 * 线程数为16 的数据
 * Benchmark                   (N)  Mode  Cnt   Score   Error  Units
 * FjDemoJMH.executorTasks       8  avgt    6  20.959 ± 0.444  ms/op
 * FjDemoJMH.executorTasks      20  avgt    6  26.956 ± 0.762  ms/op
 * FjDemoJMH.executorTasks      40  avgt    6  42.734 ± 0.910  ms/op
 * FjDemoJMH.executorTasks      80  avgt    6  68.009 ± 0.874  ms/op
 * FjDemoJMH.forkJoinAllTasks    8  avgt    6  51.382 ± 2.322  ms/op
 * FjDemoJMH.forkJoinAllTasks   20  avgt    6  70.847 ± 1.657  ms/op
 * FjDemoJMH.forkJoinAllTasks   40  avgt    6  77.586 ± 2.670  ms/op
 * FjDemoJMH.forkJoinAllTasks   80  avgt    6  83.838 ± 1.591  ms/op
 * FjDemoJMH.forkJoinTasks       8  avgt    6  51.770 ± 1.724  ms/op
 * FjDemoJMH.forkJoinTasks      20  avgt    6  71.023 ± 1.646  ms/op
 * FjDemoJMH.forkJoinTasks      40  avgt    6  77.547 ± 1.286  ms/op
 * FjDemoJMH.forkJoinTasks      80  avgt    6  86.674 ± 1.385  ms/op
 */
@BenchmarkMode({ Mode.AverageTime })
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 3, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@Threads(8)
@State(Scope.Thread)
public class FjDemoJMH {

    //任务数，每个任务会随机sleep一段时间
    @Param({ "8", "20", "40", "80" })
    public int N;
    long[] numbers;

    ForkJoinPool pool;
    int parallism;
    ExecutorService exPool;

    ;

    @Setup
    public void init() {
        Random r = new Random();
        r.setSeed(0x32106234567L);
        numbers = new long[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = r.nextInt(20);
        }

        parallism = 16;
        pool = new ForkJoinPool(parallism);
        exPool = Executors.newFixedThreadPool(parallism);
    }

    @TearDown
    public void shutdown() {
        pool.shutdown();
        exPool.shutdown();
    }

    /**
     * 常规线程池
     */
    @Benchmark
    public long executorTasks() {
        Calculator calculator = new ExecutorServiceCalculator(exPool, parallism);
        long sum = calculator.sumUp(numbers);
        //System.out.println("executorTasks=" + sum);
        return sum;
    }

    /**
     * fork/join线程池
     */
    @Benchmark
    public long forkJoinTasks() {
        Calculator calculator = new ForkJoinCalculator(pool);
        long sum = calculator.sumUp(numbers);
        //System.out.println("forkJoinTasks=" + sum);
        return sum;
    }

    /**
     * fork/join All线程池
     */
    @Benchmark
    public long forkJoinAllTasks() {
        Calculator calculator = new ForkJoinInvokAllCalculator(pool);
        long sum = calculator.sumUp(numbers);
        //System.out.println("forkJoinAllTasks=" + sum);
        return sum;
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(FjDemoJMH.class.getSimpleName()).forks(2).build();
        new Runner(options).run();

    }
}
