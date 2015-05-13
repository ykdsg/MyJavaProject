package com.hz.yk.module;

import com.hz.yk.module.modules.ArrangeModule;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wuzheng.yk
 *         Date: 15/5/7
 *         Time: 09:43
 */
public class Main {

    private static ApplicationContext loadContext() {
        String[] configs = new String[]{"com/taobao/jhs/module/beans.xml"};
        return new ClassPathXmlApplicationContext(configs);
    }

    private static <T> T getBean(ApplicationContext ctx, String name) {
        return (T) ctx.getBean(name);
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = loadContext();
        ItemDO itemDO = new ItemDO();
        itemDO.setSalesSite(1);
        ArrangeModule arrangeModule = (ArrangeModule) applicationContext.getBean("arrangeModule");
        arrangeModule.publish(itemDO);
        System.out.println("----------------222222-------------------");
        itemDO.setSalesSite(2);
        arrangeModule.publish(itemDO);
    }
}
