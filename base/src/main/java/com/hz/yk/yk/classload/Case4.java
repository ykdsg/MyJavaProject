package com.hz.yk.yk.classload;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 简单测试一下动态代理
 * @author wuzheng.yk
 *         Date: 15/1/29
 *         Time: 11:13
 */
public class Case4 {
    public static void main(String[] args) {
        try {
            RfqService rfqService = (RfqService) Proxy.newProxyInstance(MyClassLoader.class.getClassLoader(), new Class[]{RfqService.class}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) {
                    return method.getName();
                }
            });
            System.out.println(rfqService.getClass().getClassLoader());
            System.out.println(rfqService.getRfqTestName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
