package com.hz.yk.ddd.zy.ch23.demo1.application;

import com.hz.yk.ddd.zy.ch23.demo1.domain.NotificationComposer;
import com.hz.yk.ddd.zy.ch23.demo1.domain.Order;
import com.hz.yk.ddd.zy.ch23.demo1.domain.OrderConfirmedComposer;
import com.hz.yk.ddd.zy.ch23.demo1.domain.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 应用服务
 * @author wuzheng.yk
 * @date 2022/9/7
 */
@Service
public class OrderAppService {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private NotificationComposer notificationComposer;
    @Autowired
    private OrderConfirmedComposer orderConfirmedComposer;
    @Autowired
    private EventBus eventBus;
    @Autowired
    private PlaceOrderService placeOrderService;

    public void placeOrder(Order order) {
        try {
            placeOrderService.execute(order);
            notificationService.send(notificationComposer.compose(order));
            eventBus.publish(orderConfirmedComposer.compose(order));
        } catch (Exception ex) {
            throw ex;
            //throw new ApplicationException(ex.getMessage());
        }
    }
}
