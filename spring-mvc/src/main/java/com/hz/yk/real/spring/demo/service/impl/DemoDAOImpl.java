package com.hz.yk.real.spring.demo.service.impl;

import com.hz.yk.real.spring.demo.service.DemoDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author wuzheng.yk
 * @date 2020/2/10
 */
public class DemoDAOImpl implements DemoDAO, InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(DemoDAOImpl.class);

    public DemoDAOImpl() {
        log.warn("DemoDAO new****************");
    }

    @Override
    public void get(String name) {
        log.warn("DAO get");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.warn("DemoDAO init****************");
    }
}
