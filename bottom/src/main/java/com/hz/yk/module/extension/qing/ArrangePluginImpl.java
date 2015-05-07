package com.hz.yk.module.extension.qing;

import com.hz.yk.module.TestService;
import com.hz.yk.module.plugin.ArrangePlugin;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wuzheng.yk
 *         Date: 15/5/7
 *         Time: 10:11
 */
public class ArrangePluginImpl implements ArrangePlugin {
    TestService testService;
    @Override
    public void arrange() {
        testService.sayHi();
        System.out.println("qing arrange");
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }
}
