package com.hz.yk.ddd.geek.model.ch04_02.impl.db;

import com.google.common.collect.Lists;
import com.hz.yk.ddd.geek.model.ch04_02.models.MySubscriptions;
import com.hz.yk.ddd.geek.model.ch04_02.models.Subscription;
import com.hz.yk.ddd.geek.model.ch04_02.models.User;

import java.util.List;

/**
 * 具体持久化操作
 *
 * @author wuzheng.yk
 * @date 2021/11/17
 */
public class MySubscriptionsDB implements MySubscriptions {

    private User user;

    public MySubscriptionsDB(User user) {
        this.user = user;
    }

    @Override
    public List<Subscription> subList(int from, int to) {
        return Lists.newArrayList();
    }

    @Override
    public long getTotalSubscriptionFee() {
        return 0;
    }

    @Override
    public int count() {
        return 0;
    }
}
