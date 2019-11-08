package com.hz.yk.functor.monad;

import java.util.function.Function;

/**
 * @author wuzheng.yk
 * @date 2019/10/30
 */
public class Tuple2<T1, T2> {

    final T1 t1;
    final T2 t2;

    public Tuple2(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    /**
     * 转换后的纯函数
     *
     * @param x
     * @return
     */
    Tuple2<Integer, Integer> increase1(int x) {
        return new Tuple2<>(x + 1, 1);
    }

    Tuple2<Integer, Integer> decrease1(int x) {
        return new Tuple2<>(x - 1, -1);
    }

    /**
     * 组合方式也需要改变
     *
     * @param func1
     * @param func2
     * @return
     */
    Function<Integer, Tuple2<Integer, Integer>> compose(Function<Integer, Tuple2<Integer, Integer>> func1,
                                                        Function<Integer, Tuple2<Integer, Integer>> func2) {

        return x -> {
            Tuple2<Integer, Integer> result1 = func1.apply(x);
            Tuple2<Integer, Integer> result2 = func2.apply((result1.getT1()));
            return new Tuple2<>(result2.getT1(), result2.getT2() + result1.getT2());
        };
    }

    /**
     * 所返回的结果可以继续使用 doCompose 函数来与其他类型相同的函数进行组合
     *
     * @param x
     * @return
     */
    Tuple2<Integer, Integer> doCompose(int x) {
        return compose(this::increase1, this::decrease1).apply(x);
    }

    public T1 getT1() {
        return t1;
    }

    public T2 getT2() {
        return t2;
    }

    @Override
    public String toString() {
        return "Tuple2{" + "t1=" + t1 + ", t2=" + t2 + '}';
    }
}
