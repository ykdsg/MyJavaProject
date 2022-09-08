package com.hz.yk.ddd.zy.ch23.demo1.application;

import com.hz.yk.ddd.zy.ch23.demo1.domain.OrderConfirmed;

/**
 * @author wuzheng.yk
 * @date 2022/9/7
 */
public interface EventBus {

    void publish(OrderConfirmed composeEvent);
}
