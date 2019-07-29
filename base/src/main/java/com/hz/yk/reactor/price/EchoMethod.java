package com.hz.yk.reactor.price;

import java.util.concurrent.TimeUnit;

/**
 * @author wuzheng.yk
 * @date 2019-06-21
 */
public class EchoMethod {

    /**
     * 模拟阻塞方法
     *
     * @param str
     * @param delay
     * @param timeUnit
     * @return
     */
    public static String echoAfterTime(String str, int delay, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(str);
        return str;
    }
}
