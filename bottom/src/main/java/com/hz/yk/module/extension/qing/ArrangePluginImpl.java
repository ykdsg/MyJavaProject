package com.hz.yk.module.extension.qing;

import com.hz.yk.module.IcService;
import com.hz.yk.module.plugin.ArrangePlugin;

/**
 * @author wuzheng.yk
 *         Date: 15/5/7
 *         Time: 10:11
 */
public class ArrangePluginImpl implements ArrangePlugin {
    IcService icService;
    @Override
    public void arrange() {
        icService.doPublish();
        System.out.println("qing arrange");
    }

    public void setIcService(IcService icService) {
        this.icService = icService;
    }
}
