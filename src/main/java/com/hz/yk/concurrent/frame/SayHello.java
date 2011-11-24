package com.hz.yk.concurrent.frame;

/**
 * Created by IntelliJ IDEA.
 * User: yangke
 * Date: 11-8-21
 * Time: обнГ2:40
 * To change this template use File | Settings | File Templates.
 */
public class SayHello implements MethodRequest {
    public SayHello(Service s) {
        _service = s;
    }

    public void call() {
        _service.sayHello();
    }

    private Service _service;
}