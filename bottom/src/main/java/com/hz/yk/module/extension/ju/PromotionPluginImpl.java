package com.hz.yk.module.extension.ju;

import com.hz.yk.module.plugin.PromotionPlugin;

/**
 * @author wuzheng.yk
 *         Date: 15/5/7
 *         Time: 14:25
 */
public class PromotionPluginImpl implements PromotionPlugin {
    @Override
    public void promotion() {
        System.out.println("ju promotion done");
    }
}
