package com.hz.yk.real.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuzheng.yk
 * @date 2019-08-19
 */

@Service
public class UseUserDemoService {

    @Resource
    UserDemoService userDemoService;

    @Autowired
    IAnimal dogImpl;

    public void test() {
        System.out.println(dogImpl);
    }
}
