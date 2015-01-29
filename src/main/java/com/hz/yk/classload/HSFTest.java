package com.hz.yk.classload;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 通过动态代理来生成web app命名空间的代理对象，命名空间一致，就不会出现上面命名空间隔离的问题
 * PS: 反射可以穿透命名空间，所以可以直接使用反射对另外一个命名空间的Class进行操作，如HSFTest里面反射操作RfqRequestDTO。
 * @author wuzheng.yk
 *         Date: 15/1/29
 *         Time: 11:25
 */
public class HSFTest {
    public HSFTest() {
        System.out.println("我是HSFTest,我被：" + this.getClass().getClassLoader() + "   加载了！");
    }

    public Object getObject(Class<?> interfaceClass, final Class<?> returnClass) {
        return Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object o = returnClass.newInstance();
                returnClass.getDeclaredMethod("setName", String.class).invoke(o, "invoke " + method.getName());
                return o;
            }
        });
    }
}
