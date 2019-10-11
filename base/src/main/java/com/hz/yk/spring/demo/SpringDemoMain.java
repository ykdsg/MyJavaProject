package com.hz.yk.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wuzheng.yk
 * @date 2019-08-19
 */
public class SpringDemoMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_demo.xml");
        UseUserDemoService bean = context.getBean(UseUserDemoService.class);
        System.out.println(bean);

        bean.test();
    }

}
