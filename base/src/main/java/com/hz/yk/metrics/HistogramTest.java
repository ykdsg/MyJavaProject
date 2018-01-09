package com.hz.yk.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.ExponentiallyDecayingReservoir;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.MetricRegistry;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Histogram 统计数据的分布情况。比如最小值，最大值，中间值，还有中位数，75百分位, 90百分位, 95百分位, 98百分位, 99百分位, 和 99.9百分位的值(percentiles)
 * Created by wuzheng.yk on 2017/7/31.
 */
public class HistogramTest {
    public static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        MetricRegistry registry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        reporter.start(1, TimeUnit.SECONDS);
        Histogram histogram = new Histogram(new ExponentiallyDecayingReservoir());
        registry.register(MetricRegistry.name(HistogramTest.class, "request", "histogram"), histogram);

        for (int i = 0; i < 30; i++) {
            new Thread(){
                @Override
                public void run() {
                    histogram.update(random.nextInt(100));
                }
            }.start();
        }
        LockSupport.park();

    }


}
