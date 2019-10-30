package com.hz.yk.functor;

import java.util.function.Function;

/**
 * @author wuzheng.yk
 * @date 2019/10/24
 */
public interface FunctorV0<T> {

    <R> FunctorV0<R> map(Function<T, R> f);

}
