package com.hz.yk.spi;

/**
 * @author wuzheng.yk
 * @date 2019-08-16
 */
public class ChineseDemoServiceImpl implements DemoService {

    @Override
    public String sayHi(String msg) {

        return "你好, " + msg;
    }

}
