package com.hz.yk.real.spring.demo.service.impl;

import com.hz.yk.real.spring.demo.service.DemoDAO;
import com.hz.yk.real.spring.demo.service.DemoManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuzheng.yk
 * @date 2020/2/10
 */
@Service
public class DemoManageImpl implements DemoManage, InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(DemoManageImpl.class);

    @Autowired
    private DemoDAO demoDAO;

    @Override
    public void add() {
        demoDAO.get("");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.warn("DemoManage init###########");
    }
}
