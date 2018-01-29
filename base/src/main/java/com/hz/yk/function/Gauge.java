package com.hz.yk.function;

/**
 * Created by wuzheng.yk on 2018/1/30.
 */
@FunctionalInterface
public interface Gauge<T> {
    T getValue();
}
