package com.hz.yk.rpc;

/**
 * @author wuzheng.yk
 *         Date: 13-4-3
 *         Time: ионГ10:08
 */
public class HelloServiceImpl implements HelloService {

    public String hello(String name) {
        return "Hello " + name;
    }
}