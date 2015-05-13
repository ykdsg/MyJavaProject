package com.hz.yk.module.extension.ju;

import com.hz.yk.module.IcService;
import com.hz.yk.module.plugin.TagPlugin;

/**
 * @author wuzheng.yk
 *         Date: 15/5/7
 *         Time: 10:11
 */
public class TagPluginImpl implements TagPlugin {
    IcService icService;

    @Override
    public void tag() {
        icService.doTag();
        System.out.println("ju tag");
    }

    public void setIcService(IcService icService) {
        this.icService = icService;
    }
}
