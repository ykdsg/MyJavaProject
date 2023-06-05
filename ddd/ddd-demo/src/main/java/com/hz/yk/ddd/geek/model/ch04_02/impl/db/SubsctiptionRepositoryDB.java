package com.hz.yk.ddd.geek.model.ch04_02.impl.db;

import com.google.common.collect.Lists;
import com.hz.yk.ddd.geek.model.ch04_02.models.Subscription;
import com.hz.yk.ddd.geek.model.ch04_02.models.SubscriptionRepository;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2021/11/18
 */
public class SubsctiptionRepositoryDB implements SubscriptionRepository {

    @Override
    public List<Subscription> queryPage(long userId, int from, int to) {
        return Lists.newArrayList();
    }
}
