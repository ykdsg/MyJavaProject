package com.hz.yk.javassist;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.Proxy;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wuzheng.yk
 * @date 2021/4/15
 */
public class JavassistProxy {

    private static final AtomicInteger counter = new AtomicInteger(1);

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        final NoDefaultConstructor proxy = getProxy(NoDefaultConstructor.class);
        proxy.method1();
    }

    private static String generateClassName(Class<?> type) {
        return String.format("%s$Proxy%d", type.getName(), counter.getAndIncrement());
    }

    public static <T> T getProxy(Class<T> type) throws IllegalAccessException, InstantiationException {
        ProxyFactory f = new ProxyFactory();
        f.setSuperclass(type);
        f.setFilter(new MethodFilter() {

            @Override
            public boolean isHandled(Method m) {
                // ignore finalize()
                return !m.getName().equals("finalize");
            }
        });

        Class<T> c = f.createClass();
        MethodHandler mi = new MethodHandler() {

            @Override
            public Object invoke(Object self, Method m, Method proceed, Object[] args) throws Throwable {
                System.out.println("method name: " + m.getName() + " exec");
                return proceed.invoke(self, args);  // execute the original method.
            }
        };
        T proxy = c.newInstance();
        ((Proxy) proxy).setHandler(mi);
        return proxy;
    }
}
