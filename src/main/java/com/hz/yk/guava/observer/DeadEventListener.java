package com.hz.yk.guava.observer;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * 如果没有消息订阅者监听消息, EventBus将发送DeadEvent消息, 这时我们可以通过log的方式来记录这种状态
 * @author yangke
 *         Date: 13-7-25
 *         Time: 下午3:43
 */
public class DeadEventListener {
    boolean notDelivered = false;

    @Subscribe
    public void listen(DeadEvent event) {
        notDelivered = true;
    }

    public boolean isNotDelivered() {
        return notDelivered;
    }
}
