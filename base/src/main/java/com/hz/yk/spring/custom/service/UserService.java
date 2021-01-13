package com.hz.yk.spring.custom.service;

import com.hz.yk.spring.custom.RetrofitService;

/**
 * Created by wuzheng.yk on 16/9/9.
 */
@RetrofitService
public class UserService {

    public void say() {
        System.out.println("hello world");
    }
}
