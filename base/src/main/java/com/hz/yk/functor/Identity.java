package com.hz.yk.functor;

import java.util.function.Function;

/**
 * @author wuzheng.yk
 * @date 2019/10/24
 */
public class Identity<T> implements Functor<T, Identity<?>> {

    private final T value;

    public Identity(T value) {
        this.value = value;
    }

    @Override
    public <R> Identity<R> map(Function<T, R> function) {
        R result = function.apply(value);
        return new Identity<>(result);
    }
}
