package com.hz.yk.module.util;

import com.hz.yk.module.adapter.PluginAdapter;
import com.hz.yk.module.router.RouterInfo;

/**
 * @author wuzheng.yk
 *         Date: 15/5/7
 *         Time: 14:21
 */
public class PluginUtil {
    private static PluginAdapter pluginAdapter;


    public static  <T> T getInstance(Class<T> clazz,RouterInfo routerInfo) {
        return pluginAdapter.getInstance(clazz,routerInfo);
    }


    public void setPluginAdapter(PluginAdapter pluginAdapter) {
        PluginUtil.pluginAdapter = pluginAdapter;
    }
}
