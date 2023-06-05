package com.hz.yk.ddd.geek.model.ch04_02.models;

import java.util.List;

/**
 * 具体持久化操作
 *
 * @author wuzheng.yk
 * @date 2021/11/17
 */
public class MySubscriptions {

    private SubscriptionRepository subscriptionRepository;

    private User user;

    public MySubscriptions(User user, SubscriptionRepository subscriptionRepository) {
        this.user = user;
        this.subscriptionRepository = subscriptionRepository;
    }

    public List<Subscription> subList(int from, int to) {
        final List<Subscription> subscriptions = subscriptionRepository.queryPage(user.getId(), from, to);
        return subscriptions;
    }

    public long getTotalSubscriptionFee() {
        return 0;
    }

    public int count() {
        return 0;
    }
}
