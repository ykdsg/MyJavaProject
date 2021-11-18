package com.hz.yk.ddd.geek.model.ch04_02.impl.db;

import com.hz.yk.ddd.geek.model.ch04_02.models.User;
import com.hz.yk.ddd.geek.model.ch04_02.models.UserRepostitory;

/**
 * @author wuzheng.yk
 * @date 2021/11/17
 */
public class UserRepostitoryDB implements UserRepostitory {

    @Override
    public User findById(long id) {
        User user = new User();
        return user;
    }

}
