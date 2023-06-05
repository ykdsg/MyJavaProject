package com.hz.yk.ddd.zy.ch23.demo3.domain;

import com.hz.yk.ddd.zy.ch23.common.InvalidOrderException;
import com.hz.yk.ddd.zy.ch23.demo3.interfaces.EventBus;
import com.hz.yk.ddd.zy.ch23.demo3.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wuzheng.yk
 * @date 2022/9/8
 */
public class PlaceOrderService {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private EventBus eventBus;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private NotificationComposer notificationComposer;

    public void execute(Order order) {
        if (!order.isValid()) {
            throw new InvalidOrderException(String.format("The order with id %s is invalid.", order.id()));
        }
        orderRepository.save(order);
        notificationService.send(notificationComposer.compose(order));
        eventBus.publish(new OrderConfirmed(order));
    }
}
