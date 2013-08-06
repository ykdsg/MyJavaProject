package com.hz.yk.guava.observer;

import com.google.common.eventbus.Subscribe;

/**
 * @author yangke
 *         Date: 13-7-25
 *         Time: 下午3:52
 */
public class IntegerListener {
    private Integer lastMessage;

    @Subscribe
    public void listen(Integer integer) {
        lastMessage = integer;
    }

    public Integer getLastMessage() {
        return lastMessage;
    }
}
