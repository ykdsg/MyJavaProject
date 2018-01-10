package com.hz.yk.metrics.spring_prometheus;

import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;
import io.prometheus.client.exporter.MetricsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Queue;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by wuzheng.yk on 2017/12/21.
 */
public class SpringPromeMetricsMain {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringMetricsPrometheusConfigure.class);
        TestBean testBean = applicationContext.getBean(TestBean.class);



        Counter workPoolSizeCounter = applicationContext.getBean("workPoolSizeCounter",Counter.class);
        workPoolSizeCounter.inc();
        workPoolSizeCounter.inc();
        workPoolSizeCounter.inc();

        workPoolSizeCounter.dec();

        MetricRegistry metricRegistry = applicationContext.getBean(MetricRegistry.class);
        Counter pendingJobs = metricRegistry.counter(MetricRegistry.name(Queue.class, "pending-jobs", "size"));
        pendingJobs.inc();

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

        for (int i = 0; i < 100; i++) {
            testBean.timedMethod();
            Thread.sleep(500);

        }
        LockSupport.park();
    }
    private void test1() {

        int c = test(1, 2);
        int d = test(3, 4);

    }
    private  int test(int a,int b) {
        return a + b;
    }
}
