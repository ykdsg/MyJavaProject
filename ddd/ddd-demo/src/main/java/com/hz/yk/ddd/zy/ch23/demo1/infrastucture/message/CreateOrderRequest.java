package com.hz.yk.ddd.zy.ch23.demo1.infrastucture.message;

import com.hz.yk.ddd.zy.ch23.demo1.domain.Order;

/**
 * @author wuzheng.yk
 * @date 2022/9/7
 */
public class CreateOrderRequest {

    public boolean isInvalid() {
        return true;
    }

    public Order toOrder() {
        return null;
    }
}
