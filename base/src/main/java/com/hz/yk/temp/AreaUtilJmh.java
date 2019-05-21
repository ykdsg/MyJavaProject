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

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 多个区域求交集是新的左右树的方式比较快
 * Benchmark                  (N)  Mode  Cnt     Score      Error  Units
 * AreaUtilJmh.testNewUtil   2000  avgt    3   138.938 ±   44.454  ms/op
 * AreaUtilJmh.testNewUtil   4000  avgt    3   253.600 ±   71.476  ms/op
 * AreaUtilJmh.testNewUtil   8000  avgt    3   474.319 ±  194.974  ms/op
 * AreaUtilJmh.testNewUtil  16000  avgt    3   906.224 ±  111.002  ms/op
 * AreaUtilJmh.testOldUtil   2000  avgt    3   337.919 ±  161.870  ms/op
 * AreaUtilJmh.testOldUtil   4000  avgt    3   733.070 ± 1666.523  ms/op
 * AreaUtilJmh.testOldUtil   8000  avgt    3  1279.091 ±   78.746  ms/op
 * AreaUtilJmh.testOldUtil  16000  avgt    3  2541.113 ±  223.754  ms/op
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
public class AreaUtilJmh {

    String areaStr1 = ";1;2:36;3:37;3:40;3:41;3:42;4:48;4:51;4:52;4:55;10:108;10:109;10:110;11:121;11:122;11:123;11:127;12:132;12:134;12:142;14:158;14:168;15:169;15:170;15:172;15:174;15:183;15:185;16;17:203;18:217;18:220;18:221;19:231;22;23:269;24:290;25:299;27:322;28:332;28:336:10089;28:332:11088;";
    //String areaStr2 = ";1;2;3:41;28:332;28:336:10089;";
    String areaStr2 = ";1;2;3;4;5:59;5:60;5:62;6;7:85;7:86;7:87;8:94;9;10;11;12;13;14;15;16;17:203;17:204;17:205;17:206;17:207;17:208;17:209;17:210;17:211;17:212;17:213;17:214;18:217;18:218;18:219;18:220;18:221;18:222;18:223;18:224;18:225;18:226;18:227;18:228;18:229;19;27:322;";

    @Param({ "2000", "4000", "8000", "16000" })
    public int N;

    /**
     * 提前预热一下数据
     */
    @Setup
    public void init() {
        AreaUtilNew.getAreaX(areaStr1);
        AreaUtilNew.getAreaX(areaStr2);
    }

    @Benchmark
    public void testNewUtil() {
        for (int i = 0; i < N; i++) {
            List<String> intersect = AreaUtilNew.intersect(areaStr1, areaStr2);
        }
        List<String> intersect = AreaUtilNew.intersect(areaStr1, areaStr2);
        System.out.println(intersect);
    }

    @Benchmark
    public void testOldUtil() {
        for (int i = 0; i < N; i++) {
            List<String> intersect = AreaUtilOld.intersect(areaStr1, areaStr2);
        }
        List<String> intersect = AreaUtilOld.intersect(areaStr1, areaStr2);
        System.out.println(intersect);
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(AreaUtilJmh.class.getSimpleName()).build();
        new Runner(options).run();
    }
}
