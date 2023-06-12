package com.hz.yk.metrics.prometheus;

import com.codahale.metrics.MetricRegistry;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.dropwizard.DropwizardExports;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by wuzheng.yk on 2018/1/3.
 */
public class PrometheusExportsTest {

    private CollectorRegistry registry = new CollectorRegistry();
    private MetricRegistry metricRegistry;

    @BeforeAll
    public void setUp() {
        metricRegistry = new MetricRegistry();
        new DropwizardExports(metricRegistry).register(registry);
    }

    @Test
    public void testCounter() {
        metricRegistry.counter("foo_bar").inc();
        assertEquals(new Double(1), registry.getSampleValue("foo_bar"));
    }
}
