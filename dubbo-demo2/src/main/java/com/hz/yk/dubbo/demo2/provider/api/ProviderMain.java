package com.hz.yk.dubbo.demo2.provider.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wuzheng.yk
 * @date 2018/11/8
 */
public class ProviderMain {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Thread.currentThread().join();
    }

}
