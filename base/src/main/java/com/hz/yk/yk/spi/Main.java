package com.hz.yk.yk.spi;

import com.hz.yk.spi.HelloInterface;
import java.util.ServiceLoader;

/**
 * @author wuzheng.yk
 *         Date: 15/4/13
 *         Time: 17:45
 */
public class Main {
    private static ServiceLoader<HelloInterface> serviceLoader = ServiceLoader.load(HelloInterface.class);

    public static void main(String[] args) {
        for (HelloInterface service : serviceLoader) {
            service.sayHi();
        }
    }

}
