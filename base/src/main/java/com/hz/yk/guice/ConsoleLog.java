package com.hz.yk.guice;

/**
 * @author wuzheng.yk
 * @date 2020/9/2
 */
public class ConsoleLog implements ILog {

    @Override
    public void log(String msg) {
        System.out.println("log:" + msg);
    }
}
