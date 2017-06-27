package com.hz.yk.camel.demo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 路由类。路由就好比是Camel中怎样将消息从一端传递到另一端的一个指令定义，每隔一秒向处理器发送一个消息，简单打印出来
 * Created by wuzheng.yk on 15/11/2.
 */
public class TimerRouteBuilder extends RouteBuilder {
    private static final Logger log = LoggerFactory.getLogger(TimerRouteBuilder.class);

    @Override
    public void configure() {
        from("timer://timer1?period=1000")
                .process(new Processor() {
                    public void process(Exchange msg) {
                        log.info("Processing {}", msg);
                    }
                });
    }
}
