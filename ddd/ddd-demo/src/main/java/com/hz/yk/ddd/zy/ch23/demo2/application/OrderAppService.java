package com.hz.yk.ddd.zy.ch23.demo2.application;

import com.hz.yk.ddd.zy.ch23.common.ApplicationException;
import com.hz.yk.ddd.zy.ch23.common.InvalidOrderException;
import com.hz.yk.ddd.zy.ch23.demo2.domain.Order;
import com.hz.yk.ddd.zy.ch23.demo2.domain.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wuzheng.yk
 * @date 2022/9/7
 */
public class OrderAppService {
    @Autowired
    private PlaceOrderService placeOrderService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private EventBus eventBus;

    public void placeOrder(Order order) {
        try {
            placeOrderService.register(new OrderEventHandler(notificationService, eventBus));
            placeOrderService.execute(order);
        } catch (InvalidOrderException ex) {
            throw new ApplicationException(ex.getMessage());
        }
    }

}
