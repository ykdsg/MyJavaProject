package com.hz.yk.ddd.geek.model.ch05.context.impl;

import com.hz.yk.ddd.geek.model.ch05.context.SocialContext;
import com.hz.yk.ddd.geek.model.ch05.context.SubscriptionContext;
import com.hz.yk.ddd.geek.model.ch05.models.User;

/**
 * @author wuzheng.yk
 * @date 2021/11/22
 */
public class SubscriptionContextImpl implements SubscriptionContext {

    //为了处理"只有朋友"才能赠送的逻辑，需要注入依赖
    SocialContext socialContext;

    @Override
    public Reader asReader(User user) {
        //将依赖的上下文socialContext传给reader
        return null;
    }
}
