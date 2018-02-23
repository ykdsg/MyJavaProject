package com.hz.yk.fastjson;

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
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by wuzheng.yk on 2018/2/23.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@Threads(8)
@State(Scope.Benchmark)
public class Obj2MapJMH {
    @Param({ "100", "200", "400", "1600" })
    public int N;

    List<Student> stuList;
    @Setup
    public void init() {

        stuList = new ArrayList<Student>(N );

        for (int i = 0; i < N; i++) {
            Student stu = new Student();
            stu.setName("rr");
            Family family = new Family();
            family.setCreateTime(new Date());
            family.setfList(Lists.newArrayList("5", "6", null));
            stu.setFamily(family);
            stu.setsList(Lists.newArrayList("1","2",null));

            stuList.add(stu);
        }
    }

    @Benchmark
    public Object testReflect2Map() {
        return stuList.stream().map(stu -> ReflectObject2MapUtil.convertToMap(stu)).collect(Collectors.toList());
    }


    @Benchmark
    public Object testJackson2Map() {
        return stuList.stream().map(stu -> JacksonObject2MapUtil.convertToMap(stu)).collect(Collectors.toList());
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(Obj2MapJMH.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }

}
