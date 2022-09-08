package com.hz.yk.ddd.zy.ch23.demo2.application;

import com.hz.yk.ddd.zy.ch23.demo2.domain.OrderConfirmed;

/**
 * 事件总线，类似消息通道
 * @author wuzheng.yk
 * @date 2022/9/7
 */
public interface EventBus {

    void publish(OrderConfirmed composeEvent);
}
