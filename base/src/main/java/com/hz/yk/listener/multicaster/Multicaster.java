package com.hz.yk.listener.multicaster;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author wuzheng.yk
 * @date 2021/3/16
 */
public abstract class Multicaster<L extends Listener> implements Listenable<L> {

    /**
     * 泛型接口的代理实例，在代理实例上调用事件，则将此调用广播给所有已添加的监听器
     * 定义为listeners在调用时会像作用在所有监听器上一样(事实上确实是)如: multicaster.listeners.onXxxEvent();
     */
    public final L listeners;
    /**
     * 读取子类设置的listener接口类型，用于创建代理
     */
    private final Class<L> listenerInterfaceClass;

    private final Set<L> eventListeners = new CopyOnWriteArraySet<>();

    @SuppressWarnings("unchecked")
    protected Multicaster() {
        //子类继承后需声明listener接口类型，如果为null或者泛型不是接口则抛出异常
        Type genericType = Objects
                .requireNonNull(((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        if (genericType instanceof ParameterizedType) {
            //如果是带泛型接口则获取接口类型
            genericType = ((ParameterizedType) genericType).getRawType();
        }

        listenerInterfaceClass = (Class<L>) genericType;
        if (!listenerInterfaceClass.isInterface()) {
            throw new IllegalArgumentException(listenerInterfaceClass + " is not Interface!");
        }
        this.listeners = createProxy();
    }

    @Override
    public void addListener(L listener) {
        eventListeners.add(Objects.requireNonNull(listener));
    }

    @Override
    public void removeListener(L listener) {
        eventListeners.remove(listener);
    }

    /**
     * 创建针对监听器接口的代理对象
     *
     * @return 代理对象
     */
    protected L createProxy() {
        Object proxy = Proxy
                .newProxyInstance(listenerInterfaceClass.getClassLoader(), new Class[]{ listenerInterfaceClass },
                                  new MulticastInvocationHandler());
        return listenerInterfaceClass.cast(proxy);
    }

    protected class MulticastInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, final Method method, final Object[] args) throws Throwable {
            for (L listener : eventListeners) {
                method.invoke(listener, args);
            }
            return null;
        }
    }
}
