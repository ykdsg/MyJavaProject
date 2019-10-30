package com.hz.yk.functor;

import java.util.function.Function;

/**
 * @author wuzheng.yk
 * @date 2019/10/24
 */
public interface Functor<T, F extends Functor<?, ?>> {

    <R> F map(Function<T, R> function);

}
