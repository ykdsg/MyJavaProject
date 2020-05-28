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
 * Benchmark                   (N)  Mode  Cnt    Score   Error  Units
 * FjDemoJMH.executorTasks       8  avgt    6   20.974 ± 0.389  ms/op
 * FjDemoJMH.executorTasks      20  avgt    6   26.868 ± 0.725  ms/op
 * FjDemoJMH.executorTasks      40  avgt    6   42.715 ± 1.170  ms/op
 * FjDemoJMH.executorTasks      80  avgt    6   67.506 ± 0.925  ms/op
 * FjDemoJMH.executorTasks     500  avgt    6  358.708 ± 3.993  ms/op
 * FjDemoJMH.forkJoinAllTasks    8  avgt    6   32.068 ± 0.470  ms/op
 * FjDemoJMH.forkJoinAllTasks   20  avgt    6   45.678 ± 0.442  ms/op
 * FjDemoJMH.forkJoinAllTasks   40  avgt    6   50.168 ± 0.900  ms/op
 * FjDemoJMH.forkJoinAllTasks   80  avgt    6   84.531 ± 1.507  ms/op
 * FjDemoJMH.forkJoinAllTasks  500  avgt    6  424.916 ± 6.401  ms/op
 * FjDemoJMH.forkJoinTasks       8  avgt    6   32.125 ± 0.598  ms/op
 * FjDemoJMH.forkJoinTasks      20  avgt    6   46.008 ± 0.597  ms/op
 * FjDemoJMH.forkJoinTasks      40  avgt    6   50.752 ± 0.603  ms/op
 * FjDemoJMH.forkJoinTasks      80  avgt    6   83.274 ± 1.426  ms/op
 * FjDemoJMH.forkJoinTasks     500  avgt    6  405.517 ± 2.145  ms/op
 * 线程数为32的数据
 * Benchmark                   (N)  Mode  Cnt    Score    Error  Units
 * FjDemoJMH.executorTasks       8  avgt    6   21.041 ±  0.298  ms/op
 * FjDemoJMH.executorTasks      20  avgt    6   21.683 ±  0.808  ms/op
 * FjDemoJMH.executorTasks      40  avgt    6   23.055 ±  0.548  ms/op
 * FjDemoJMH.executorTasks      80  avgt    6   42.649 ±  1.109  ms/op
 * FjDemoJMH.executorTasks     500  avgt    6  189.430 ±  1.831  ms/op
 * FjDemoJMH.forkJoinAllTasks    8  avgt    6   31.902 ±  0.634  ms/op
 * FjDemoJMH.forkJoinAllTasks   20  avgt    6   45.909 ±  0.760  ms/op
 * FjDemoJMH.forkJoinAllTasks   40  avgt    6   50.606 ±  1.032  ms/op
 * FjDemoJMH.forkJoinAllTasks   80  avgt    6   55.146 ±  0.547  ms/op
 * FjDemoJMH.forkJoinAllTasks  500  avgt    6  250.843 ± 10.557  ms/op
 * FjDemoJMH.forkJoinTasks       8  avgt    6   31.784 ±  0.535  ms/op
 * FjDemoJMH.forkJoinTasks      20  avgt    6   45.662 ±  0.667  ms/op
 * FjDemoJMH.forkJoinTasks      40  avgt    6   50.577 ±  1.067  ms/op
 * FjDemoJMH.forkJoinTasks      80  avgt    6   55.534 ±  0.597  ms/op
 * FjDemoJMH.forkJoinTasks     500  avgt    6  245.678 ±  9.795  ms/op
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
    @Param({ "8", "20", "40", "80", "500" })
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

        parallism = 32;
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
        Calculator calculator = new ExecutorServiceCalculator(exPool);
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
