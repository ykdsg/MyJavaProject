package com.hz.yk.orika;

import com.brucecloud.fastclone.FastClone;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import net.sf.cglib.beans.BeanCopier;
import org.dozer.DozerBeanMapper;
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

import java.util.concurrent.TimeUnit;

/**
 * 使用jmh 更加严谨的测量一下
 * 结果是cglib 完胜
 * Created by wuzheng.yk on 2017/12/21.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@Threads(8)
@State(Scope.Benchmark)
public class CopyBenchmark {
    @Param({ "40000", "80000", "160000" })
    public int N;


    static DozerBeanMapper dozer         = new DozerBeanMapper();
    static MapperFactory   mapperFactory = new DefaultMapperFactory.Builder().build();
    static MapperFacade    orikaMapper   = mapperFactory.getMapperFacade();
    static FastClone       fastClone     = new FastClone();

    User customer = new User(11211L, "testName");
    User employee = new User();

    @Benchmark
    public  void testFastClone() throws Exception {
        for (int i = 0; i < N; i++) {
            Object clone = fastClone.clone(customer);
        }
    }
    @Benchmark
    public  void testCglibBeanCopier() {
        for (int i = 0; i < N; i++) {
            BeanCopier copier = BeanCopier.create(customer.getClass(), employee.getClass(), false);
            copier.copy(customer, employee, null);
        }
    }

    @Benchmark
    public  void testOrika() {
        for (int i = 0; i < N; i++) {
            orikaMapper.map(customer, employee);
        }
    }

    @Benchmark
    public  void testDozer() {
        for (int i = 0; i < N; i++) {
            dozer.map(customer, employee);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(CopyBenchmark.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }
}
