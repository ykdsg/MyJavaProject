package com.hz.yk.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author wuzheng.yk
 *         Date: 14-7-11
 *         Time: 下午5:32
 */
public class BookFacadeCglib implements MethodInterceptor {

    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    public static Object getInstance(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        // 回调方法
        enhancer.setCallback(new BookFacadeCglib());
        // 创建代理对象
        return enhancer.create();
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("事物开始");
        methodProxy.invokeSuper(obj, args);
        System.out.println("事物结束");
        return null;
    }
}

