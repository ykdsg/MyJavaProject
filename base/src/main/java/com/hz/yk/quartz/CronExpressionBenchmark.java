package com.hz.yk.quartz;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.quartz.CronExpression;

import java.util.concurrent.TimeUnit;

/**
 * CronExpression创建的耗时，基本在0.03ms
 *
 * @author wuzheng.yk
 * @date 2018/9/3
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@Threads(8)
@State(Scope.Benchmark)
public class CronExpressionBenchmark {

    @Benchmark
    public void testNew() throws Exception {
        CronExpression expression = new CronExpression("0 0 12 * * ?");
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(CronExpressionBenchmark.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }

}
