package com.hz.yk.module.modules;

import com.hz.yk.module.IcService;
import com.hz.yk.module.ItemDO;
import com.hz.yk.module.plugin.TagPlugin;
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
    IcService icService;

    @Override
    public void publish(ItemDO itemDO) {
        System.out.println("start publish ,,,,");
        //调用ic的服务去发布商品
        icService.doPublish();
        RouterInfo routerInfo =PluginRouter.getInfo(itemDO);
        //调用优惠插件去打上优惠
        PromotionPlugin promotionPlugin = PluginUtil.getInstance(PromotionPlugin.class,routerInfo);
        promotionPlugin.promotion();
        //调用打标插件去打标
        TagPlugin tagPlugin = PluginUtil.getInstance(TagPlugin.class,routerInfo);
        tagPlugin.tag();
        System.out.println("publish success,,,,");
    }

    public void setIcService(IcService icService) {
        this.icService = icService;
    }
}
