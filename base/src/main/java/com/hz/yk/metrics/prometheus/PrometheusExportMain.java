package com.hz.yk.metrics.prometheus;

import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.dropwizard.DropwizardExports;
import io.prometheus.client.exporter.MetricsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by wuzheng.yk on 2018/1/10.
 */
public class PrometheusExportMain {
    // Create registry for Dropwizard metrics.
    static final MetricRegistry metrics = new MetricRegistry();
    // Create a Dropwizard counter.
    static final Counter        counter = metrics.counter("my_example_counter_total");

    static {
        //metrics.register("jvm.gc", new GarbageCollectorMetricSet());
        //metrics.register("jvm.memory", new MemoryUsageGaugeSet());
        //metrics.register("jvm.thread-states", new ThreadStatesGaugeSet());
        //metrics.register("jvm.fd.usage", new FileDescriptorRatioGauge());
    }
    public static void main(String[] args) throws Exception {
        // Hook the Dropwizard registry into the Prometheus registry
        // via the DropwizardExports collector.
        CollectorRegistry.defaultRegistry.register(new DropwizardExports(metrics));

        runCounter(true);
        runCounter(false);


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

    private static void runCounter(boolean isInc) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    long sleepMillis = isInc ? 300 : 500;
                    try {
                        Thread.sleep(sleepMillis);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (isInc) {
                        counter.inc();
                    } else {
                        counter.dec();

                    }
                }
            }
        }).start();
    }
}
