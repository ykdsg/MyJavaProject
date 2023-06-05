package com.hz.yk.ddd.geek.model.ch04_01;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * user 作为聚合根，管控对应的Subscription ，但是带来的问题是怎么解决在页面分页显示订阅的专栏
 *
 * @author wuzheng.yk
 * @date 2021/11/17
 */
public class User {

    private List<Subscription> subscriptions;

    /**
     * 获取用户订阅的所有专栏
     *
     * @return
     */
    public List<Subscription> getSubscriptions() {
        return Lists.newArrayList();
    }

    /**
     * 计算所订阅专栏的总价
     *
     * @return
     */
    public long getTotalSubscriptionFee() {
        return 9999;
    }
}
