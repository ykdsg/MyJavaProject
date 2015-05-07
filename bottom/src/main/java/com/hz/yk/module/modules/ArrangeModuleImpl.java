package com.hz.yk.module.modules;

import com.hz.yk.module.ItemDO;
import com.hz.yk.module.TestService;
import com.hz.yk.module.plugin.ArrangePlugin;
import com.hz.yk.module.plugin.PromotionPlugin;
import com.hz.yk.module.router.PluginRouter;
import com.hz.yk.module.router.RouterInfo;
import com.hz.yk.module.util.PluginUtil;

/**
 * @author wuzheng.yk
 *         Date: 15/5/7
 *         Time: 14:47
 */
public class ArrangeModuleImpl implements ArrangeModule{
    TestService testService;


    @Override
    public void publish(ItemDO itemDO) {
        RouterInfo routerInfo =PluginRouter.getInfo(itemDO);
        System.out.println("start publish ,,,,");
        testService.sayHi();
        //扩展点
        PromotionPlugin promotionPlugin = PluginUtil.getInstance(PromotionPlugin.class,routerInfo);
        promotionPlugin.promotion();
        //扩展点
        ArrangePlugin arrangePlugin = PluginUtil.getInstance(ArrangePlugin.class,routerInfo);
        arrangePlugin.arrange();
        System.out.println("publish success,,,,");
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }
}
