package com.hz.yk.ddd.geek.model.ch04_01;

/**
 * @author wuzheng.yk
 * @date 2021/11/17
 */
public class Main {

    public static void main(String[] args) {
        User user = new User();
        //这里在实际落地的过程中会有问题，subscriptions并不是在内存中，是在数据库里面的
        user.getSubscriptions().subList(0, 10);

    }

}
