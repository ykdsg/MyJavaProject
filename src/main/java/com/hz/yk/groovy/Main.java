package com.hz.yk.groovy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wuzheng.yk
 *         Date: 12-11-14
 *         Time: обнГ4:38
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application_groovy.xml");
        ProtoBusiness business= (ProtoBusiness) ctx.getBean("protoBusiness",ProtoBusiness.class);
        business.doSomething();

    }
}
