package com.hz.yk.ddd.geek.model.ch04_01;

import com.hz.yk.ddd.geek.model.Page;

/**
 * 为订阅单独构造一个Repository 对象，这样会导致逻辑泄露。Subscription 被User 所拥有，那么Subscription 的集合逻辑应该被封装在User中。
 * 但是把这块底层逻辑直接放入User 中也不合适，因为领域层就感知底层的实现细节。
 *
 * @author wuzheng.yk
 * @date 2021/11/17
 */
public interface SubscriptionRepository {

    Page<Subscription> findPaginated(int from, int size);
}
