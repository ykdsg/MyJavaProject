package com.hz.yk.ddd.geek.model.ch05;

import com.hz.yk.ddd.geek.model.ch05.context.OrderContext;
import com.hz.yk.ddd.geek.model.ch05.context.SocialContext;
import com.hz.yk.ddd.geek.model.ch05.context.SubscriptionContext;
import com.hz.yk.ddd.geek.model.ch05.models.User;

/**
 * 书上的模型是从Repository这边直接构造好的
 *
 * @author wuzheng.yk
 * @date 2021/11/22
 */
public class UserRepositoryDB implements UserRepository {

    //private UserMapper userMapper;

    //通过注入获取不同的上下文对象
    private SubscriptionContext subscriptionContext;
    private OrderContext orderContext;
    private SocialContext socialContext;

    @Override
    public User findUserById(long id) {
        return null;
    }

    @Override
    public SubscriptionContext inSubscriptionConetxt() {
        return subscriptionContext;
    }

    @Override
    public OrderContext inOrderContext() {
        return orderContext;
    }

    @Override
    public SocialContext inSocialContext() {
        return socialContext;
    }
}
