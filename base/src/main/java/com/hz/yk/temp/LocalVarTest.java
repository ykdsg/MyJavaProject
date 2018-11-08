package com.hz.yk.temp;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 结果显示使用方法内本地变量并不一定能提升明显的性能，但是使用Long作为对象的时候确实能提升一个数量级，具体的情况需要具体分析
 *
 * @author wuzheng.yk
 * @date 2018/11/7
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@Threads(8)
@State(Scope.Benchmark)
public class LocalVarTest {

    private Long instVar = 0L;// 成员变量

    private Set<String> setVar = new HashSet<>();

    @Param({ "40000", "80000", "160000" })
    public int N;

    private void addTemp(String s) {
        Set<String> tempSet = setVar;
        if (tempSet == null) {
            setVar = new HashSet<>();
            tempSet = setVar;
        }
        tempSet.add(s);

    }

    private void addInstance(String s) {
        if (setVar == null) {
            setVar = new HashSet<>();
        }
        setVar.add(s);
    }

    //@Benchmark
    public void forTemp() {
        for (long i = 0; i < N; i++) {
            addTemp(i + "");
        }
    }

    //@Benchmark
    public void forInstance() {
        for (long i = 0; i < N; i++) {
            addInstance(i + "");
        }
    }

    // 存取类方法中的临时变量
    @Benchmark
    public void tempAccess() {
        Set<String> tempSet = setVar;
        for (long i = 0; i < N; i++) {
            tempSet.add(i + "");
        }
    }

    // 存取类的成员变量
    @Benchmark
    public void instanceAccess() {
        for (long i = 0; i < N; i++) {
            setVar.add(i + "");
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(LocalVarTest.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }
}
