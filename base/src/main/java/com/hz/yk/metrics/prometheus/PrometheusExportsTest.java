package com.hz.yk.metrics.prometheus;

import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.dropwizard.DropwizardExports;
import io.prometheus.client.exporter.MetricsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by wuzheng.yk on 2018/1/3.
 */
public class PrometheusExportsTest {

    private CollectorRegistry registry = new CollectorRegistry();
    private MetricRegistry metricRegistry;

    @Before
    public void setUp() {
        metricRegistry = new MetricRegistry();
        new DropwizardExports(metricRegistry).register(registry);
    }

    @Test
    public void testCounter() {
        metricRegistry.counter("foo_bar").inc();
        assertEquals(new Double(1), registry.getSampleValue("foo_bar"));
    }

    // Create registry for Dropwizard metrics.
    static final MetricRegistry metrics = new MetricRegistry();
    // Create a Dropwizard counter.
    static final Counter        counter = metrics.counter("my_example_counter_total");

    static {
        metrics.register("jvm.gc", new GarbageCollectorMetricSet());
        metrics.register("jvm.memory", new MemoryUsageGaugeSet());
        //metrics.register("jvm.thread-states", new ThreadStatesGaugeSet());
        //metrics.register("jvm.fd.usage", new FileDescriptorRatioGauge());
    }
    public static void main(String[] args) throws Exception {
        // Increment the counter.
        counter.inc();

        // Hook the Dropwizard registry into the Prometheus registry
        // via the DropwizardExports collector.
        CollectorRegistry.defaultRegistry.register(new DropwizardExports(metrics));

        // Expose Prometheus metrics.
        Server server = new Server(1234);
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new MetricsServlet()), "/metrics");
        // Add metrics about CPU, JVM memory etc.
        //DefaultExports.initialize();
        // Start the webserver.
        server.start();
        server.join();
    }
}
