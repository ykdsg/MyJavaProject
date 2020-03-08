package com.hz.yk.real.spring.demo.service;

import com.hz.yk.real.spring.demo.service.impl.DemoDAOImpl;

/**
 * @author wuzheng.yk
 * @date 2020/2/10
 */
public class DaoFactory {

    public static DemoDAO createDAO() {
        return new DemoDAOImpl();
    }
}
