package com.hz.yk.fockjoin.jmh;

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
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 20, time = 3, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@Threads(8)
@State(Scope.Benchmark)
public class FJPBenchmarkJMH {

    @Param({ "200", "400", "800", "1600" })
    public int N;

    public List<RecursiveTask<Double>> tasks;
    public ForkJoinPool pool = new ForkJoinPool();

    @Setup
    public void init() {
        Random r = new Random();
        r.setSeed(0x32106234567L);
        tasks = new ArrayList<RecursiveTask<Double>>(N * 3);

        for (int i = 0; i < N; i++) {
            tasks.add(new Sin(r.nextDouble()));
            tasks.add(new Cos(r.nextDouble()));
            tasks.add(new Tan(r.nextDouble()));
        }
    }

    @Benchmark
    public double forkJoinTasks() {
        for (RecursiveTask<Double> task : tasks) {
            pool.submit(task);
        }
        double sum = 0;

        Collections.reverse(tasks);
        for (RecursiveTask<Double> task : tasks) {
            sum += task.join();
        }

        return sum;
    }

    //@Benchmark
    public double computeDirectly() {
        double sum = 0;
        for (RecursiveTask<Double> task : tasks) {
            sum += ((DummyComputableThing) task).dummyCompute();
        }
        return sum;
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(FJPBenchmarkJMH.class.getSimpleName()).forks(2).build();
        new Runner(options).run();
    }

}
