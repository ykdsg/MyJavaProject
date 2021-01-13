package com.hz.yk.spring.mvc.demo.service.impl;

import com.hz.yk.spring.mvc.annotation.Service;
import com.hz.yk.spring.mvc.demo.service.DemoService;

/**
 * ClassName DemoServiceImpl
 * Description 测试业务逻辑
 * Author xiaoshami
 * Date 2018/8/9 下午4:54
 **/
@Service
public class DemoServiceImpl implements DemoService {

    public String get(String name) {

        String result = "Hello World !!! " + name;

        return result;
    }

}

