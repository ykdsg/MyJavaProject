package com.hz.yk.cucumber.service;

import com.hz.yk.cucumber.domain.DemoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuzheng.yk
 * @date 2019/9/2
 */
@Service
public class ServiceA {

    @Autowired
    DemoDTO demoDTO;

    public void test() {
        System.out.println("--------@@@spring bean:" + demoDTO);
    }
}
