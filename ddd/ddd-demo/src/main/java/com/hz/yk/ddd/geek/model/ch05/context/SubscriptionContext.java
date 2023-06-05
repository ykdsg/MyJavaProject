package com.hz.yk.ddd.geek.model.ch05.context;

import com.hz.yk.ddd.geek.model.ch05.models.Content;
import com.hz.yk.ddd.geek.model.ch05.models.Subscription;
import com.hz.yk.ddd.geek.model.ch05.models.User;

/**
 * @author wuzheng.yk
 * @date 2021/11/22
 */
public interface SubscriptionContext {

    interface Reader {

        boolean canView(Content content);

        Subscription getSubsctiption(long subsctipitonId);

        //赠送课程，但是只有朋友间才可以赠送
        boolean transfer(Subscription subscription, User friend);

    }

    Reader asReader(User user);

}
