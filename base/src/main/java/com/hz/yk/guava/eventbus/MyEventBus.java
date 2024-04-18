package com.hz.yk.guava.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wuzheng.yk
 * @date 2024/4/18
 */
public class MyEventBus {

    private static final Logger log = LoggerFactory.getLogger(MyEventBus.class);
    private final AsyncEventBus eventBus;

    public MyEventBus() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        eventBus = new AsyncEventBus(executor,
                                     (ex,
                                             context) -> log.error("EventBusError,post event exception, event={}, handler={}",
                                                                   context.getEvent(), context.getSubscriber(), ex));
    }

    public void register(Object subscriber) {
        if (subscriber == null) {
            return;
        }
        eventBus.register(subscriber);
    }

    public void post(TestEvent event) {
        eventBus.post(event);
    }
}
