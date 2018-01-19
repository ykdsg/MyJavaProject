package com.hz.yk.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.ScheduledReporter;
import com.codahale.metrics.Timer;
import metrics_influxdb.HttpInfluxdbProtocol;
import metrics_influxdb.InfluxdbReporter;
import metrics_influxdb.api.measurements.CategoriesMetricMeasurementTransformer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Timer其实是 Histogram 和 Meter 的结合， histogram 某部分代码/调用的耗时， meter统计TPS
 * Created by wuzheng.yk on 2017/7/31.
 */
public class TimerTest {

    public static Random random = new Random();

    public static void main(String[] args) throws Exception {
        MetricRegistry registry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        //ScheduledReporter reporter = influxdbReporter(registry);
        reporter.start(1, TimeUnit.SECONDS);
        Timer timer = registry.timer(MetricRegistry.name(TimerTest.class, "get-latency"));
        Timer.Context ctx;
        while (true) {
            ctx = timer.time();
            Thread.sleep(random.nextInt(1000));
            ctx.stop();
        }
    }

    public static ScheduledReporter influxdbReporter(MetricRegistry registry) {

        return InfluxdbReporter.forRegistry(registry).protocol(
                new HttpInfluxdbProtocol("http", "10.168.182.213", 7086, "", "", "metrics_test")).
                                       convertRatesTo(TimeUnit.SECONDS).convertDurationsTo(
                TimeUnit.MILLISECONDS).filter(MetricFilter.ALL).skipIdleMetrics(false).tag("cluster", "CL01").tag(
                "client", "OurImportantClient").tag("server", "127.0.0.1").transformer(
                new CategoriesMetricMeasurementTransformer("module", "artifact")).build();

    }

}
