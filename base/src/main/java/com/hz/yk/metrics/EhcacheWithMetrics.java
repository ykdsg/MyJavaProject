package com.hz.yk.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.ehcache.InstrumentedEhcache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import java.util.concurrent.TimeUnit;

/**
 * Created by wuzheng.yk on 2017/12/15.
 */
public class EhcacheWithMetrics {

    public static void metricsCacheDemo() {

        MetricRegistry metricRegistry = new MetricRegistry();

        // lets add a Console reporter to the metrics
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry).convertRatesTo(
                TimeUnit.SECONDS).convertDurationsTo(TimeUnit.MILLISECONDS).build();
        reporter.start(1, TimeUnit.SECONDS);

        CacheManager cacheManager = CacheManager.newInstance();
        Ehcache cache = cacheManager.addCacheIfAbsent("testCache");

        Ehcache instrumentedCache = InstrumentedEhcache.instrument(metricRegistry, cache);

        // lets add 10K elemnets

        for (int i = 0; i < 100000; i++) {
            Element cacheElement = new Element("Key-" + i, "Value-" + i);
            instrumentedCache.put(cacheElement);
            instrumentedCache.get("Key-" + i);
        }

        cacheManager.shutdown();
    }

    public static void main(String[] args) {
        metricsCacheDemo();
    }

}
