package com.hz.yk.ddd.geek.model.ch05.role;

import com.hz.yk.ddd.geek.model.ch05.models.Content;
import com.hz.yk.ddd.geek.model.ch05.models.Subscription;
import com.hz.yk.ddd.geek.model.ch05.models.User;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2021/11/22
 */
public class Reader {

    private User user;

    private List<Subscription> subscriptions;

    public Reader(User user) {
        this.user = user;
    }

    //订阅上下文
    public boolean canView(Content content) {
        return true;
    }
}
