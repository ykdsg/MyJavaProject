package com.hz.yk.module.plugin;

/**
 * @author wuzheng.yk
 *         Date: 15/5/7
 *         Time: 17:13
 */
public class DefaultPromotionPlugin implements PromotionPlugin{
    @Override
    public void promotion() {
        System.out.println("default promotion run ,,,");
    }
}
