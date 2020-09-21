package com.hz.yk.rpc.client;

import com.hz.yk.rpc.api.EchoApi;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @author wuzheng.yk
 * @date 2020/9/21
 */
public class EchoApiFactoryBean implements FactoryBean<EchoApi> {

    @Override
    public EchoApi getObject() throws Exception {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Object proxyInstance = Proxy
                .newProxyInstance(contextClassLoader, new Class[]{ EchoApi.class }, new RPCInvocationHandler());
        return (EchoApi) proxyInstance;
    }

    @Override
    public Class<?> getObjectType() {
        return EchoApi.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
