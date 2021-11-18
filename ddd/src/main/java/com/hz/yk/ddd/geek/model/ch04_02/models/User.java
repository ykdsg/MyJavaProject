package com.hz.yk.ddd.geek.model.ch04_02.models;

import com.hz.yk.ddd.geek.model.ch04_02.impl.db.MySubscriptionsDB;

/**
 * 领域模型，领域根
 *
 * @author wuzheng.yk
 * @date 2021/11/17
 */
public class User {

    private MySubscriptions mySubscriptions;

    public MySubscriptions getMySubscriptions() {
        return mySubscriptions;
    }

    public void setMySubscription(MySubscriptionsDB mySubscriptionsDB) {
        this.mySubscriptions = mySubscriptionsDB;
    }
}
