package com.hz.yk.spring.demo2;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author wuzheng.yk
 * @date 2019/9/25
 */
public class Client implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("client after proper");
    }
}
