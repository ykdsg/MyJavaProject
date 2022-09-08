package com.hz.yk.ddd.zy.ch23.demo2.domain;

import com.hz.yk.ddd.zy.ch23.common.InvalidOrderException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wuzheng.yk
 * @date 2022/9/7
 */
public class PlaceOrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private NotificationComposer notificationComposer;

    private OrderEventPublisher publisher;

    public void register(OrderEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void execute(Order order) {
        if (!order.isValid()) {
            throw new InvalidOrderException(String.format("The order with id %s is invalid.", order.id()));
        }
        orderRepository.save(order);
        fireNotificationComposedEvent(order);
        fireOrderConfirmedEvent(order);
    }

    private void fireNotificationComposedEvent(Order order) {
        Notification notification = notificationComposer.compose(order);
        publisher.publish(new NotificationComposed(notification));
    }
    private void fireOrderConfirmedEvent(Order order) {
        publisher.publish(new OrderConfirmed(order));
    }

}
