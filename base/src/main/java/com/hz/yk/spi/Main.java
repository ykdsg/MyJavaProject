package com.hz.yk.spi;

import java.util.ServiceLoader;

/**
 * @author wuzheng.yk
 * @date 2019-08-16
 */
public class Main {

    public static void main(String[] args) {
        ServiceLoader<DemoService> serviceLoader = ServiceLoader.load(DemoService.class);

        for (DemoService demoService : serviceLoader) {
            System.out.println("class:" + demoService.getClass().getName() + "***" + demoService.sayHi("World"));
        }
    }
}
