package com.hz.yk.yk.camel.demo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
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
