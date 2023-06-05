package com.hz.yk.ddd.zy.ch23.demo1.infrastucture;

import com.hz.yk.ddd.zy.ch23.demo1.application.OrderAppService;
import com.hz.yk.ddd.zy.ch23.demo1.domain.Order;
import com.hz.yk.ddd.zy.ch23.demo1.infrastucture.message.CreateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wuzheng.yk
 * @date 2022/9/7
 */
public class OrderController {
    @Autowired
    private OrderAppService service;


    //@RequestMapping(method = RequestMethod.POST)
    public void create(CreateOrderRequest request) {
        if (request.isInvalid()) {
            throw new BadRequestException("the request of placing order is invalid.");
        }
        Order order = request.toOrder();
        service.placeOrder(order);
    }

}
