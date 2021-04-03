package com.hz.yk.listener.multicaster;

/**
 * @author wuzheng.yk
 * @date 2021/3/16
 */
public abstract class MulticasterSupport<L extends Listener> implements Listenable<L> {

    protected final Multicaster<L> multicaster = createMulticaster();

    protected abstract Multicaster<L> createMulticaster();

    @Override
    public void addListener(L listener) {
        multicaster.addListener(listener);
    }

    @Override
    public void removeListener(L listener) {
        multicaster.removeListener(listener);
    }

}
