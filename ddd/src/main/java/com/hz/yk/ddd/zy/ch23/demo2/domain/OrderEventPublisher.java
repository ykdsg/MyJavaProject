package com.hz.yk.ddd.zy.ch23.demo2.domain;

/**
 * 发布者接口，定义在domain层，被同一层的PlaceOrderService 依赖，实现在application 层。
 * @author wuzheng.yk
 * @date 2022/9/7
 */
public interface OrderEventPublisher {
    void publish(NotificationComposed event);

    void publish(OrderConfirmed orderConfirmed);
}
