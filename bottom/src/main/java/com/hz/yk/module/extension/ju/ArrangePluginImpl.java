package com.hz.yk.module.extension.ju;

import com.hz.yk.module.TestService;
import com.hz.yk.module.plugin.ArrangePlugin;
import com.hz.yk.module.plugin.PromotionPlugin;
import com.hz.yk.module.util.PluginUtil;

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
        System.out.println("ju arrange");
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }
}
