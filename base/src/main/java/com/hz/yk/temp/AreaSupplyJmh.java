package com.hz.yk.temp;

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

import java.util.concurrent.TimeUnit;

/**
 * 单个区域是否可供还是字符串拼接比较快
 * Benchmark                   (N)  Mode  Cnt   Score    Error  Units
 * AreaSupplyJmh.testNewUtil   200  avgt    3   5.124 ±  1.213  ms/op
 * AreaSupplyJmh.testNewUtil   400  avgt    3  12.238 ± 26.653  ms/op
 * AreaSupplyJmh.testNewUtil   800  avgt    3  23.606 ±  7.011  ms/op
 * AreaSupplyJmh.testNewUtil  1600  avgt    3  48.486 ± 35.257  ms/op
 * AreaSupplyJmh.testOldUtil   200  avgt    3   3.843 ±  0.767  ms/op
 * AreaSupplyJmh.testOldUtil   400  avgt    3   7.391 ±  3.248  ms/op
 * AreaSupplyJmh.testOldUtil   800  avgt    3  13.739 ±  2.655  ms/op
 * AreaSupplyJmh.testOldUtil  1600  avgt    3  27.077 ±  8.167  ms/op
 *
 * @author wuzheng.yk
 * @date 2019-05-20
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 3, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@Threads(8)
@State(Scope.Benchmark)
public class AreaSupplyJmh {

    String areaStr1 = ";1;2:36;3:37;3:40;3:41;3:42;4:48;4:51;4:52;4:55;10:108;10:109;10:110;11:121;11:122;11:123;11:127;12:132;12:134;12:142;14:158;14:168;15:169;15:170;15:172;15:174;15:183;15:185;16;17:203;18:217;18:220;18:221;19:231;22;23:269;24:290;25:299;27:322;28:332;28:336:10089;28:332:11088;";

    AreaUtilNew.AreaX        areaX        = AreaUtilNew.getAreaX("28:332:11088").get(0);
    AreaUtilOld.ProvinceArea provinceArea = new AreaUtilOld.ProvinceArea("28", "332", "11088");

    @Param({ "200", "400", "800", "1600" })
    public int N;

    /**
     * 提前预热一下数据
     */
    @Setup
    public void init() {
        AreaUtilNew.getAreaX(areaStr1);
    }

    @Benchmark
    public void testNewUtil() {
        for (int i = 0; i < N; i++) {
            AreaUtilNew.isSupply(areaStr1, areaX);
        }
        System.out.println(AreaUtilNew.isSupply(areaStr1, areaX));
    }

    @Benchmark
    public void testOldUtil() {
        for (int i = 0; i < N; i++) {
            AreaUtilOld.isSupplyAreaSimpleBySupplyDetail(provinceArea, areaStr1);
        }
        System.out.println(AreaUtilOld.isSupplyAreaSimpleBySupplyDetail(provinceArea, areaStr1));
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(AreaSupplyJmh.class.getSimpleName()).build();
        new Runner(options).run();
    }
}
