package com.hz.yk.listener.multicaster;

/**
 * @author wuzheng.yk
 * @date 2021/3/16
 */
public interface Listenable<T> {

    void addListener(T listener);

    void removeListener(T listener);
}
