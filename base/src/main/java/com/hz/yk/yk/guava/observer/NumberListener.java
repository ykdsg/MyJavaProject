package com.hz.yk.yk.guava.observer;

import com.google.common.eventbus.Subscribe;

/**
 * @author yangke
 *         Date: 13-7-25
 *         Time: 下午3:51
 */
public class NumberListener {
    private Number lastMessage;

    @Subscribe
    public void listen(Number integer) {
        lastMessage = integer;
    }

    public Number getLastMessage() {
        return lastMessage;
    }
}
