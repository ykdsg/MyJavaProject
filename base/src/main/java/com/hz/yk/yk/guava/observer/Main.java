package com.hz.yk.yk.guava.observer;

import com.google.common.eventbus.EventBus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author yangke
 *         Date: 13-7-25
 *         Time: 下午3:11
 */
public class Main {

    @Test
    public void shouldReceiveEvent() throws Exception {

        // given
        EventBus eventBus = new EventBus("test");
        EventObserver listener = new EventObserver();

        eventBus.register(listener);

        // when
        eventBus.post(new OurTestEvent(200));

        // then
        assertEquals(listener.getLastMessage(),200);
    }

    @Test
    public void shouldDetectEventWithoutListeners() throws Exception {

        // given
        EventBus eventBus = new EventBus("test");

        DeadEventListener deadEventListener = new DeadEventListener();
        eventBus.register(deadEventListener);

        // when
        eventBus.post(new OurTestEvent(200));

        assertTrue(deadEventListener.isNotDelivered());
    }

    /**
     * 如果Listener A监听Event A, 而Event A有一个子类Event B, 此时Listener A将同时接收Event A和B消息
     * @throws Exception
     */
    @Test
    public void shouldGetEventsFromSubclass() throws Exception {

        // given
        EventBus eventBus = new EventBus("test");
        IntegerListener integerListener = new IntegerListener();
        NumberListener numberListener = new NumberListener();
        eventBus.register(integerListener);
        eventBus.register(numberListener);

        // when
        eventBus.post(new Integer(100));

        // then
        assertTrue(integerListener.getLastMessage()==100);
        assertTrue(numberListener.getLastMessage().intValue()==100);

        //when
        eventBus.post(new Long(200L));

        // then
        // this one should has the old value as it listens only for Integers
        assertTrue(integerListener.getLastMessage()==100);
        assertTrue(numberListener.getLastMessage().intValue()==200L);
    }
}
