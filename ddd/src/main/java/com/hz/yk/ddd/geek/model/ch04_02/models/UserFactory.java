package com.hz.yk.ddd.geek.model.ch04_02.models;

import com.hz.yk.ddd.geek.model.ch04_02.impl.db.SubsctiptionRepositoryDB;
import com.hz.yk.ddd.geek.model.ch04_02.impl.db.UserRepostitoryDB;

/**
 * @author wuzheng.yk
 * @date 2021/11/18
 */
public class UserFactory {

    //框架注入
    private UserRepostitory userRepostitory = new UserRepostitoryDB();
    //框架注入
    private SubscriptionRepository subsctiptionRepositoryDB = new SubsctiptionRepositoryDB();

    public User getUserById(long id) {
        final User user = userRepostitory.findById(id);
        user.setMySubscription(new MySubscriptions(user, subsctiptionRepositoryDB));
        return user;
    }

}
