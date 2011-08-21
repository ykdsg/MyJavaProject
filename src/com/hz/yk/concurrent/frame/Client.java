package com.hz.yk.concurrent.frame;

/**
 * Created by IntelliJ IDEA.
 * User: yangke
 * Date: 11-8-21
 * Time: обнГ2:56
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    public Client(Service s) {
        _service = s;
    }

    public void requestService() {
        _service.sayHello();
    }

    private Service _service;
}