package com.hz.yk.spi;

/**
 * @author wuzheng.yk
 * @date 2019-08-16
 */
public class EnglishDemoServiceImpl implements DemoService {

    @Override
    public String sayHi(String msg) {

        return "Hello, " + msg;
    }
}
