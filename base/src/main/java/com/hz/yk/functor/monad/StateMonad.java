package com.hz.yk.functor.monad;

import java.util.function.Function;

/**
 * State Monad 可以在计算中附加任意类型的状态值。State Monad 与 Reader Monad 相似，只是 State Monad 在转换时会返回一个新的状态对象，从而可以描述可变的环境。
 *
 * @author wuzheng.yk
 * @date 2019/10/31
 */
public class StateMonad {

    public static <T, S> Function<S, Tuple2<T, S>> unit(T value) {
        return s -> new Tuple2<>(value, s);
    }

    public static <T1, T2, S> Function<S, Tuple2<T2, S>> bind(Function<S, Tuple2<T1, S>> input,
                                                              Function<T1, Function<S, Tuple2<T2, S>>> transform) {

        return s -> {
            Tuple2<T1, S> result = input.apply(s);
            return transform.apply(result.getT1()).apply(result.getT2());
        };
    }

    public static void main(String[] args) {
        Function<String, Function<String, Function<State, Tuple2<String, State>>>> transform = prefix -> value -> s -> new Tuple2<>(
                prefix + value, new State(s.getValue() + value.length()));

        Function<State, Tuple2<String, State>> m1 = unit("Hello");
        Function<State, Tuple2<String, State>> m2 = bind(m1, transform.apply("1"));
        Function<State, Tuple2<String, State>> m3 = bind(m2, transform.apply("2"));
        Tuple2<String, State> result = m3.apply(new State(0));
        System.out.println(result);
    }
}
