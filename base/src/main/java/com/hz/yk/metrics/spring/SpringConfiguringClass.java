package com.hz.yk.metrics.spring;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jvm.FileDescriptorRatioGauge;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wuzheng.yk on 2017/12/20.
 */
@Configuration
@EnableMetrics
public class SpringConfiguringClass extends MetricsConfigurerAdapter {


    @Bean
    public TestBean testBean() {
        return new TestBean();
    }



    @Override
    public void configureReporters(MetricRegistry metricRegistry) {
        // registerReporter allows the MetricsConfigurerAdapter to
        // shut down the reporter when the Spring context is closed
        //registerReporter(ConsoleReporter
        //                         .forRegistry(metricRegistry)
        //                         .build())
        //        .start(2, TimeUnit.SECONDS);

        registerReporter(JmxReporter
                                 .forRegistry(metricRegistry)
                                 .build())
                .start();

        metricRegistry.register("jvm.gc", new GarbageCollectorMetricSet());
        metricRegistry.register("jvm.memory", new MemoryUsageGaugeSet());
        metricRegistry.register("jvm.thread-states", new ThreadStatesGaugeSet());
        metricRegistry.register("jvm.fd.usage", new FileDescriptorRatioGauge());
    }
}
