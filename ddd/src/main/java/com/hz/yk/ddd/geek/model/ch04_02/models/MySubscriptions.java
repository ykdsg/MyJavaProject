package com.hz.yk.ddd.geek.model.ch04_02.models;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2021/11/17
 */
public interface MySubscriptions {

    /**
     * 分页
     *
     * @param from
     * @param to
     * @return
     */
    List<Subscription> subList(int from, int to);

    /**
     * 总共花费
     *
     * @return
     */
    long getTotalSubscriptionFee();

    /**
     * 总订阅数
     *
     * @return
     */
    int count();

}
