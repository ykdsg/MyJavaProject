package com.hz.yk.my.spring.custom;

import com.hz.yk.my.spring.custom.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自定义动态装载的bean
 * Created by wuzheng.yk on 16/9/9.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("cus_beans.xml");

        UserService userService = context.getBean(UserService.class);
        userService.say();

    }
}
