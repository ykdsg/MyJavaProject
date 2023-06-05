package com.hz.yk.ddd.geek.model.ch05;

import com.hz.yk.ddd.geek.model.ch05.context.OrderContext;
import com.hz.yk.ddd.geek.model.ch05.context.SocialContext;
import com.hz.yk.ddd.geek.model.ch05.context.SubscriptionContext;
import com.hz.yk.ddd.geek.model.ch05.models.User;

/**
 * @author wuzheng.yk
 * @date 2021/11/22
 */
public interface UserRepository {

    User findUserById(long id);

    SubscriptionContext inSubscriptionConetxt();

    OrderContext inOrderContext();

    SocialContext inSocialContext();

}
