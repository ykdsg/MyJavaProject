package com.hz.yk.guava.eventbus;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wuzheng.yk
 * @date 2024/4/18
 */
public class TestSubscribe2 {

    private static final Logger log = LoggerFactory.getLogger(TestSubscribe2.class);

    @Subscribe
    public void handle(TestEvent2 event) throws InterruptedException {
        log.info("start in subscribe2");
        Thread.sleep(100);
        throw new NullPointerException("just test");
    }

}
