package com.hz.yk.ddd.zy.ch23.demo3.application;

import com.hz.yk.ddd.zy.ch23.common.ApplicationException;
import com.hz.yk.ddd.zy.ch23.common.InvalidOrderException;
import com.hz.yk.ddd.zy.ch23.demo3.domain.Order;
import com.hz.yk.ddd.zy.ch23.demo3.domain.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wuzheng.yk
 * @date 2022/9/8
 */
public class OrderAppService {

    @Autowired
    private PlaceOrderService placeOrderService;

    public void placeOrder(Order order) {
        try {
            placeOrderService.execute(order);
        } catch (InvalidOrderException  ex) { 
            throw new ApplicationException(ex.getMessage());
        }
    }

}
