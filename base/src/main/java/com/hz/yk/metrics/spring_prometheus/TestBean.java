package com.hz.yk.metrics.spring_prometheus;

import com.codahale.metrics.annotation.CachedGauge;
import com.codahale.metrics.annotation.Counted;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Gauge;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;

/**
 * Created by wuzheng.yk on 2017/12/21.
 */
public class TestBean {

    @Gauge
    private int intGaugeField = 5;

    @Gauge
    public int intGaugeMethod() {
        return 6;
    }

    @CachedGauge(timeout = 100)
    public int cachedGaugeMethod() {
        return 7;
    }

    @Timed
    public void timedMethod() {
    }

    @Metered
    public void meteredMethod() {
    }

    @Counted
    public void countedMethod(Runnable runnable) {
        if (runnable != null) runnable.run();
    }

    @ExceptionMetered
    public void exceptionMeteredMethod() {
        throw new RuntimeException();
    }
}
