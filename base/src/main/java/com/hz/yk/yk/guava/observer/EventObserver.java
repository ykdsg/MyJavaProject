package com.hz.yk.yk.guava.observer;

import com.google.common.eventbus.Subscribe;

/**
 * @author yangke
 *         Date: 13-7-25
 *         Time: 下午2:59
 */
public class EventObserver {
    public int lastMessage = 0;

    @Subscribe
    public void testListen(OurTestEvent event) {
        lastMessage = event.getMessage();
    }

    public int getLastMessage() {
        return lastMessage;
    }
}
