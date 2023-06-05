package com.hz.yk.ddd.zy.ch23.demo2.application;

import com.hz.yk.ddd.zy.ch23.demo2.domain.NotificationComposed;
import com.hz.yk.ddd.zy.ch23.demo2.domain.OrderConfirmed;
import com.hz.yk.ddd.zy.ch23.demo2.domain.OrderEventPublisher;

/**
 * @author wuzheng.yk
 * @date 2022/9/7
 */
public class OrderEventHandler implements OrderEventPublisher {
    private NotificationService notificationService;
    private EventBus eventBus;

    public OrderEventHandler(NotificationService notificationService, EventBus eventBus) {
        this.notificationService = notificationService;
        this.eventBus = eventBus;
    }

    @Override
    public void publish(NotificationComposed notificationComposed) {
        notificationService.send(notificationComposed.notification());
    }

    @Override
    public void publish(OrderConfirmed event) {
        eventBus.publish(event);
    }

}
