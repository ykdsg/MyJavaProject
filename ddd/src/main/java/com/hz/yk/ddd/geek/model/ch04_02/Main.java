package com.hz.yk.ddd.geek.model.ch04_02;

import com.hz.yk.ddd.geek.model.ch04_02.models.User;

/**
 * @author wuzheng.yk
 * @date 2021/11/17
 */
public class Main {

    public static void main(String[] args) {
        User user = new User();
        user.getMySubscriptions().subList(0, 10);
    }

}
