package com.hz.yk.yk.classload;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 命名空间隔离了
 * 传入的接口和loader不在同一个命名空间中，所以不可见，抛出异常
 * 要判断两个Class 是否相等，不但要看包名，类名，还要看命名空间和类加载器
 * @author wuzheng.yk
 *         Date: 15/1/29
 *         Time: 11:17
 */
public class Case5 {
    public static void main(String[] args) {
        MyClassLoader loader1 = new MyClassLoader(null, "loader1");// 使用根类加载器做父类，将命名空间隔离
        try {
            System.out.println(loader1.getParent());
            RfqService rfqService = (RfqService) Proxy.newProxyInstance(loader1, new Class[]{RfqService.class}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
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
