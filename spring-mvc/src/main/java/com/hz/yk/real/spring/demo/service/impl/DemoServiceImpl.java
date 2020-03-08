package com.hz.yk.real.spring.demo.service.impl;

import com.hz.yk.real.spring.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * ClassName DemoServiceImpl
 * Description 测试业务逻辑
 * Author xiaoshami
 * Date 2018/8/9 下午4:54
 **/
@Service
public class DemoServiceImpl implements DemoService, InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public String get(String name) {

        String result = "Hello World !!! " + name;

        return result;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.warn("DemoService init!!!!!!!!!!!!!!");
    }
}

