package com.hz.yk.oom;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 方法区是存放虚拟机加载类的相关信息，如类、静态变量和常量，
 * 大小由-XX:PermSize和-XX:MaxPermSize来调节，类太多有可能撑爆永久带
 *
 * 加上JVM参数-verbose:gc -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:+HeapDumpOnOutOfMemoryError，就能很快报出OOM
 * @author wuzheng.yk
 *         Date: 13-2-19
 *         Time: 下午10:20
 */
public class MethodAreaOOM {

    static class OOMOjbect {}


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        while (true) {
            Enhancer eh = new Enhancer();
            eh.setSuperclass(OOMOjbect.class);
            eh.setUseCache(false);
            eh.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(obj, args);
                }
            });
            eh.create();
        }
    }
}
