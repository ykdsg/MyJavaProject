package com.hz.yk.guava.eventbus;

import org.junit.jupiter.api.Test;

/**
 * @author wuzheng.yk
 * @date 2024/4/18
 */
public class EventBusTest {

    @Test
    public void testException() throws InterruptedException {
        MyEventBus eventBus = new MyEventBus();
        TestSubscribe1 subscribe1 = new TestSubscribe1(eventBus);
        TestSubscribe2 subscribe2 = new TestSubscribe2();

        eventBus.register(subscribe1);
        eventBus.register(subscribe2);

        eventBus.post(new TestEvent1());

        Thread.sleep(2000);

    }

}
