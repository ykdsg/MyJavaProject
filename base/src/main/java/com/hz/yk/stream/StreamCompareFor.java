package com.hz.yk.stream;

import com.google.common.collect.Lists;
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
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by wuzheng.yk on 2017/9/4.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@Threads(8)
@State(Scope.Benchmark)
public class StreamCompareFor {

    @Param({ "200", "400", "800", "1600" })
    public int N;

    private List<Long> tasks;

    @Setup
    public void init() {
        Random r = new Random();
        r.setSeed(0x32106234567L);
        tasks = new ArrayList<Long>(N );

        for (int i = 0; i < N; i++) {
            tasks.add(r.nextLong());
        }
    }

    @Benchmark
    public List<Long> testStream() {
        List<Long> distList = tasks.stream().filter(Objects::nonNull).distinct().collect(Collectors.toList());
        return distList;
    }

    @Benchmark
    public List<Long> testStream2() {
        List<Long> distList = tasks.parallelStream().filter(id -> id != null).distinct().collect(Collectors.toList());
        return distList;
    }

    @Benchmark
    public List<Long> testFor() {
        List<Long> distinctIds= Lists.newArrayList();
        for (Long  id : tasks) {
            if(!distinctIds.contains(id)){
                distinctIds.add(id);
            }
        }
        return distinctIds;
    }


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(StreamCompareFor.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }

}
