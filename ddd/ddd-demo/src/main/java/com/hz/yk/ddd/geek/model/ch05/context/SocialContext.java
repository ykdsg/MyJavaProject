package com.hz.yk.ddd.geek.model.ch05.context;

import com.hz.yk.ddd.geek.model.ch05.models.Friendship;
import com.hz.yk.ddd.geek.model.ch05.models.User;

/**
 * @author wuzheng.yk
 * @date 2021/11/22
 */
public interface SocialContext {

    interface Contact {

        void make(Friendship friendship);

        void breakShip(Friendship friendship);

        boolean isFriend(User friend);
    }

    Contact asContact(User user);
}

