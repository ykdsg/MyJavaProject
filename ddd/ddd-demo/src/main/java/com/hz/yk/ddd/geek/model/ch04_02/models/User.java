package com.hz.yk.ddd.geek.model.ch04_02.models;

/**
 * 领域模型，领域根
 *
 * @author wuzheng.yk
 * @date 2021/11/17
 */
public class User {

    private MySubscriptions mySubscriptions;

    private long id;

    public MySubscriptions getMySubscriptions() {
        return mySubscriptions;
    }

    public void setMySubscription(MySubscriptions mySubscriptions) {
        this.mySubscriptions = mySubscriptions;
    }

    public long getId() {
        return id;
    }
}
