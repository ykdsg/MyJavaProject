package com.hz.yk.module.router;

import com.hz.yk.module.ItemDO;

/**
 * @author wuzheng.yk
 *         Date: 15/5/7
 *         Time: 15:16
 */
public class PluginRouter {

    public static RouterInfo getInfo(Object obj) {
        RouterInfo info = new RouterInfo();
        if (obj instanceof ItemDO) {
            ItemDO itemDO = (ItemDO) obj;
            if (itemDO.getSalesSite() == 1) {
                info.setPackagePrefix(RouterInfo.PLUGIN_PACKAGE+"ju.");
            }else if (itemDO.getSalesSite() == 2) {
                info.setPackagePrefix(RouterInfo.PLUGIN_PACKAGE+"qing.");
            }
            return info;
        }
        throw new RuntimeException("no class instanceof can be confirm");

    }


}
