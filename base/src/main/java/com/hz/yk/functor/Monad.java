package com.hz.yk.functor;

import java.util.function.Function;

/**
 * @author wuzheng.yk
 * @date 2019/10/25
 */
public interface Monad<T, M extends Monad<?, ?>> extends Functor<T, M> {

    <R> M flatMap(Function<T, M> f);

}
