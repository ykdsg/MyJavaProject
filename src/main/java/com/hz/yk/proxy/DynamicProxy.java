package com.hz.yk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by IntelliJ IDEA.
 * User: yangke
 * Date: 11-7-20
 * Time: ÉÏÎç11:30
 * To change this template use File | Settings | File Templates.
 */
public class DynamicProxy {
    public static void main(String[] args) {
        final AandB target = new AandB();
        Object obj = Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(), new Class[]{A.class, B.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(" proxy =" + proxy.getClass());
                return method.invoke(target, args);
            }
        });
        A obja = (A) obj;
        obja.test1();
        B objb = (B) obj;
        objb.test2();
    }

    private void test() {
        System.out.println("proxy test");
    }


    interface A {
        void test1();
    }

    interface B {
        void test2();
    }

    static class AandB implements A, B {

        @Override
        public void test1() {
            System.out.println("test1");
        }

        @Override
        public void test2() {
            System.out.println("test2");
        }
    }
}
