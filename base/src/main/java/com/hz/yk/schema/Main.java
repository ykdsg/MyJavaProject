package com.hz.yk.schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wuzheng.yk
 * @date 2018/7/5
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        People people = (People) context.getBean("cutesource");
        System.out.println(people.getName());
        System.out.println(people.getAge());
    }
}
