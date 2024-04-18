package com.hz.yk.guava.eventbus;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wuzheng.yk
 * @date 2024/4/18
 */
public class TestSubscribe1 {

    private static final Logger log = LoggerFactory.getLogger(TestSubscribe1.class);

    MyEventBus eventBus;

    public TestSubscribe1(MyEventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Subscribe
    public void handle(TestEvent1 event) throws InterruptedException {
        log.info("before post event2");
        eventBus.post(new TestEvent2());
        log.info("after post event2");
        Thread.sleep(200);
        log.info("after sleep ");
    }

}
