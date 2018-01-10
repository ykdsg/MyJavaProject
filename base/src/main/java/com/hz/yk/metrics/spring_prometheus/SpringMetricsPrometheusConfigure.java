package com.hz.yk.metrics.spring_prometheus;

import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.dropwizard.DropwizardExports;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author wuzheng.yk
 * @date 2017/12/20
 */
@Configuration
@EnableMetrics
public class SpringMetricsPrometheusConfigure extends MetricsConfigurerAdapter {
    private MetricRegistry metricRegistry;



    @Bean
    public TestBean testBean() {
        return new TestBean();
    }

    //@Bean("metricRegistry")
    //public MetricRegistry getRegistry() {
    //    return metricRegistry;
    //}


    @Bean(name = "workPoolSizeCounter")
    public Counter workPoolSizeCounter() {
        return metricRegistry.counter(MetricRegistry.name("toc","wokrPool","size"));
    }


    @Override
    public void configureReporters(MetricRegistry metricRegistry) {
        // Hook the Dropwizard registry into the Prometheus registry
        // via the DropwizardExports collector.
        CollectorRegistry.defaultRegistry.register(new DropwizardExports(metricRegistry));

        // registerReporter allows the MetricsConfigurerAdapter to
        // shut down the reporter when the Spring context is closed
        //registerReporter(ConsoleReporter
        //                         .forRegistry(metricRegistry)
        //                         .build())
        //        .start(2, TimeUnit.SECONDS);

        //registerReporter(JmxReporter
        //                         .forRegistry(metricRegistry)
        //                         .build())
        //        .start();

        //metricRegistry.register("jvm.gc", new GarbageCollectorMetricSet());
        //metricRegistry.register("jvm.memory", new MemoryUsageGaugeSet());
        //metricRegistry.register("jvm.thread-states", new ThreadStatesGaugeSet());
        //metricRegistry.register("jvm.fd.usage", new FileDescriptorRatioGauge());
        this.metricRegistry = metricRegistry;

    }
}
