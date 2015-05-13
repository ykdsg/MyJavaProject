package com.hz.yk.module.plugin;

/**
 * @author wuzheng.yk
 *         Date: 15/5/7
 *         Time: 17:12
 */
public class DefaultTagPlugin implements TagPlugin {
    @Override
    public void tag() {
        System.out.println("default tag run ,,,");
    }
}
