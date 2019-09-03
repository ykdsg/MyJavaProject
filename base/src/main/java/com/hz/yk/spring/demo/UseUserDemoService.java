package com.hz.yk.spring.demo;

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

}
