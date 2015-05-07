package com.hz.yk.module.util;

import com.hz.yk.module.adapter.AdapterInvokerFactory;
import com.hz.yk.module.router.RouterInfo;

/**
 * @author wuzheng.yk
 *         Date: 15/5/7
 *         Time: 14:21
 */
public class PluginUtil {
    private static AdapterInvokerFactory adapterInvokerFactory;


    public static  <T> T getInstance(Class<T> clazz,RouterInfo routerInfo) {
        return adapterInvokerFactory.getInstance(clazz,routerInfo);
    }



    public  void setAdapterInvokerFactory(AdapterInvokerFactory adapterInvokerFactory) {
        PluginUtil.adapterInvokerFactory = adapterInvokerFactory;
    }
}
