package com.hz.yk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wuzheng.yk
 * @date 2020/8/27
 */
public class NoTragetProxyHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("doing anything");
        return null;
    }
}
