package com.hz.yk.functor.monad;

import java.util.function.Function;

/**
 * Reader Monad 也被称为 Environment Monad，描述的是依赖共享环境的计算。
 *
 * @author wuzheng.yk
 * @date 2019/10/30
 */
public class ReaderMonad {

    /**
     * Reader Monad 的类型构造器从类型 T 中创建出一元类型 E → T，而 E 是环境的类型
     *
     * @param value
     * @param <T>
     * @param <E>
     * @return
     */
    public static <T, E> Function<E, T> unit(T value) {
        return e -> value;
    }

    public static <T1, T2, E> Function<E, T2> bind(Function<E, T1> input, Function<T1, Function<E, T2>> transform) {
        return e -> transform.apply(input.apply(e)).apply(e);
    }

    public static void main(String[] args) {
        Function<Environment, String> m1 = unit("Hello");
        Function<Environment, String> m2 = bind(m1, value -> e -> e.getPrefix() + value);
        Function<Environment, Integer> m3 = bind(m2, value -> e -> e.getBase() + value.length());
        int result = m3.apply(new Environment());
        System.out.println(result);
    }
}
