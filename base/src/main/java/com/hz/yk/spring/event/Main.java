package com.hz.yk.spring.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by wuzheng.yk on 17/4/28.
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublish publish = context.getBean(DemoPublish.class);
        publish.publish("我是publish 发布的消息");
        context.close();

    }
}
