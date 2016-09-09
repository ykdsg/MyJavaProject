package com.hz.yk.spring.custom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hz.yk.spring.custom.service.UserService;

/**
 * Created by wuzheng.yk on 16/9/9.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("cus_beans.xml");

        UserService userService = context.getBean(UserService.class);
        userService.say();

    }
}
