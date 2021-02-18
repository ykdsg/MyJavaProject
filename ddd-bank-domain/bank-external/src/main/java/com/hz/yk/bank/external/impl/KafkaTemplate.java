package com.hz.yk.bank.external.impl;

import org.springframework.stereotype.Component;

/**
 * @author wuzheng.yk
 * @date 2021/2/18
 */
@Component
public class KafkaTemplate<Topic, Body> {

    public void send(Topic messageTopic, Body messageBody) {

        System.out.println("send message by kafka");
    }
}
