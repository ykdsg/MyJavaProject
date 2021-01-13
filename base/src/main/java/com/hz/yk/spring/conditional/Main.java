package com.hz.yk.spring.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by wuzheng.yk on 17/4/28.
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionalConfig.class);

        ConditinalServiceInteface service = context.getBean(ConditinalServiceInteface.class);
        System.out.println(service.description());
        context.close();
    }
}
