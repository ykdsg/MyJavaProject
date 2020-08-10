package com.hz.yk.lock;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Benchmark                 (N)  Mode  Cnt   Score   Error  Units
 * LockJmh.testTTasLock      100  avgt    2   4.812          ms/op
 * LockJmh.testTTasLock      200  avgt    2   9.981          ms/op
 * LockJmh.testTas           100  avgt    2   5.324          ms/op
 * LockJmh.testTas           200  avgt    2  12.435          ms/op
 * LockJmh.testsBackoffLock  100  avgt    2   5.368          ms/op
 * LockJmh.testsBackoffLock  200  avgt    2  11.312          ms/op
 * 从结果来看BackoffLock 没有表现的特别好，可能是跟回退的参数没有调优有一点关系，但是这块根据不同的硬件可能表现不一样。
 *
 * @author wuzheng.yk
 * @date 2020/7/31
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 2, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class LockJmh {

    private static Lock tasLock = new TimeCost(new TASLock());
    private static Lock ttasLock = new TimeCost(new TTASLock());
    private static Lock backoffLock = new TimeCost(new BackoffLock(1, 5));

    @Param({ "100", "200" })
    public int N;

    @Benchmark
    public void testTas() throws InterruptedException {
        runLock(tasLock);
    }

    @Benchmark
    public void testTTasLock() throws InterruptedException {
        runLock(ttasLock);
    }

    @Benchmark
    public void testsBackoffLock() throws InterruptedException {
        runLock(backoffLock);
    }

    private void runLock(Lock lock) throws InterruptedException {
        CountDownLatch countDown = new CountDownLatch(N);

        for (int i = 0; i < N; i++) {
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    lock.lock();
                    lock.unlock();
                    countDown.countDown();
                }

            });
            t.start();
        }
        countDown.await();
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(LockJmh.class.getSimpleName()).build();
        new Runner(options).run();
    }
}
