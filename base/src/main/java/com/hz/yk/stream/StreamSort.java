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
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 一个List 按照另一个List 的顺序排序的2种方法比较
 * Created by wuzheng.yk on 2018/2/24.
 */

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@Threads(8)
@State(Scope.Benchmark)
public class StreamSort {

    private List<Long> idList;

    private List<Stu> stuList ;

    @Param({ "200", "400", "800", "1600" })
    public int N;


    @Setup
    public void init() {
        idList = Lists.newArrayList();
        stuList = Lists.newArrayList();
        for (int i = 0; i < N; i++) {
            idList.add((long) i);
            stuList.add(new Stu((long) i));
        }
    }

    @Benchmark
    public List<Stu> testStream() {
        Map<Long, Stu> stuMap = stuList.stream().collect(Collectors.toMap(Stu::getId, Function.identity()));
        return idList.stream().map(stuMap::get).collect(Collectors.toList());
    }


    @Benchmark
    public List<Stu> testArray() {
        Stu[] stuArray = new Stu[stuList.size()];
        for (Stu stu : stuList) {
            stuArray[idList.indexOf(stu.getId())] = stu;
        }
        return Arrays.asList(stuArray);
    }

    @Benchmark
    public List<Stu> testList() {
        List<Stu> resultList = new ArrayList<>(stuList.size());
        Stu empty = new Stu();
        for (int i = 0; i < stuList.size(); i++) {
            resultList.add(empty);
        }

        for (Stu stu : stuList) {
            resultList.set(idList.indexOf(stu.getId()), stu);
        }
        return resultList;
    }


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(StreamSort.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }
}
