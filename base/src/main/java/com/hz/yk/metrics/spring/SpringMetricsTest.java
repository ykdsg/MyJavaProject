package com.hz.yk.metrics.spring;

import com.codahale.metrics.CachedGauge;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static com.hz.yk.metrics.spring.TestUtil.forCachedGaugeMethod;
import static com.hz.yk.metrics.spring.TestUtil.forCountedMethod;
import static com.hz.yk.metrics.spring.TestUtil.forExceptionMeteredMethod;
import static com.hz.yk.metrics.spring.TestUtil.forGaugeField;
import static com.hz.yk.metrics.spring.TestUtil.forGaugeMethod;
import static com.hz.yk.metrics.spring.TestUtil.forMeteredMethod;
import static com.hz.yk.metrics.spring.TestUtil.forTimedMethod;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by wuzheng.yk on 2017/12/20.
 */
public class SpringMetricsTest {
    private static AnnotationConfigApplicationContext applicationContext;
    private static MetricRegistry                     metricRegistry;
    private static TestBean testBean;

    @BeforeClass
    public static void beforeClass() {
        applicationContext = new AnnotationConfigApplicationContext(SpringConfiguringClass.class);
        metricRegistry = applicationContext.getBean(MetricRegistry.class);
        testBean = applicationContext.getBean(TestBean.class);
    }


    @AfterClass
    public static void afterClass() {
        if (applicationContext != null) {
            applicationContext.close();
        }
    }

    @Test
    public void beanIsProxied() throws Throwable {
        // Assert that the bean has been proxied
        assertNotNull(testBean);
        assertThat(AopUtils.isAopProxy(testBean), is(true));
    }

    @Test
    public void gaugeField() throws Throwable {
        // Verify that the Gauge field's value is returned
        Gauge<Integer> fieldGauge = (Gauge<Integer>) forGaugeField(metricRegistry, TestBean.class, "intGaugeField");
        assertNotNull(fieldGauge);
        assertThat(fieldGauge.getValue(), is(5));
    }

    @Test
    public void gaugeMethod() throws Throwable {
        // Verify that the Gauge method's value is returned
        Gauge<Integer> methodGauge = (Gauge<Integer>) forGaugeMethod(metricRegistry, TestBean.class, "intGaugeMethod");
        assertNotNull(methodGauge);
        assertThat(methodGauge.getValue(), is(6));
    }

    @Test
    public void cachedGaugeMethod() throws Throwable {
        // Verify that the Gauge method's value is returned
        CachedGauge<Integer> methodCachedGauge = (CachedGauge<Integer>) forCachedGaugeMethod(metricRegistry, TestBean.class, "cachedGaugeMethod");
        assertNotNull(methodCachedGauge);
        assertThat(methodCachedGauge.getValue(), is(7));
    }

    @Test
    public void timedMethod() throws Throwable {
        // Verify that the Timer's counter is incremented on method invocation
        Timer timedMethodTimer = forTimedMethod(metricRegistry, TestBean.class, "timedMethod");
        assertNotNull(timedMethodTimer);
        assertThat(timedMethodTimer.getCount(), is(0L));
        testBean.timedMethod();
        assertThat(timedMethodTimer.getCount(), is(1L));
    }

    @Test
    public void meteredMethod() throws Throwable {
        // Verify that the Meter's counter is incremented on method invocation
        Meter meteredMethodMeter = forMeteredMethod(metricRegistry, TestBean.class, "meteredMethod");
        assertNotNull(meteredMethodMeter);
        assertThat(meteredMethodMeter.getCount(), is(0L));
        testBean.meteredMethod();
        assertThat(meteredMethodMeter.getCount(), is(1L));
    }

    @Test
    public void countedMethod() throws Throwable {
        // Verify that the Meter's counter is incremented on method invocation
        final Counter countedMethodMeter = forCountedMethod(metricRegistry, TestBean.class, "countedMethod");
        assertNotNull(countedMethodMeter);
        assertThat(countedMethodMeter.getCount(), is(0L));
        testBean.countedMethod(new Runnable() {
            @Override
            public void run() {
                assertThat(countedMethodMeter.getCount(), is(1L));
            }
        });
        assertThat(countedMethodMeter.getCount(), is(0L));
    }

    @Test
    public void exceptionMeteredMethod() throws Throwable {
        // Verify that the Meter's counter is incremented on method invocation
        Meter exceptionMeteredMethodMeter = forExceptionMeteredMethod(metricRegistry, TestBean.class, "exceptionMeteredMethod");
        assertNotNull(exceptionMeteredMethodMeter);
        assertThat(exceptionMeteredMethodMeter.getCount(), is(0L));
        try {
            testBean.exceptionMeteredMethod();
        }
        catch (Throwable t) {}
        assertThat(exceptionMeteredMethodMeter.getCount(), is(1L));
    }
}
