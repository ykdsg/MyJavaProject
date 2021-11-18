package com.hz.yk.ddd.geek.model.ch04_02.models;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2021/11/18
 */
public interface SubscriptionRepository {

    /**
     * 分页
     *
     * @param from
     * @param to
     * @return
     */
    List<Subscription> queryPage(long userId, int from, int to);

}
