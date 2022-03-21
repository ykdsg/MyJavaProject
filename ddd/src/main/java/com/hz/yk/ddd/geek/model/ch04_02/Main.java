package com.hz.yk.ddd.geek.model.ch04_02;

import com.hz.yk.ddd.geek.model.ch04_02.models.Subscription;
import com.hz.yk.ddd.geek.model.ch04_02.models.User;
import com.hz.yk.ddd.geek.model.ch04_02.models.UserFactory;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2021/11/17
 */
public class Main {

    public static void main(String[] urgs) {
        UserFactory userFactory = new UserFactory();
        final User user = userFactory.getUserById(11);
        final List<Subscription> subscriptions = user.getMySubscriptions().subList(0, 10);
        System.out.println(subscriptions);
    }

}
