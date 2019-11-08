package com.hz.yk.functor.monad;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Writer Monad 的主要作用是在函数调用过程中收集辅助信息，比如日志信息或是性能计数器等。其基本的思想是把副作用中对外部环境的修改聚合起来，从而把副作用从函数中分离出来。
 * 聚合方式是每个 Writer Monad 的核心。对于聚合方式的要求和范畴中对于态射的要求是一样，也就是必须是传递的，而且有组合的基本单元。
 *
 * @author wuzheng.yk
 * @date 2019/10/30
 */
public class LoggingMonad<T> {

    private final T value;
    private final List<String> logs;

    public LoggingMonad(T value, List<String> logs) {
        this.value = value;
        this.logs = logs;
    }

    @Override
    public String toString() {
        return "LoggingMonad{" + "value=" + value + ", logs=" + logs + '}';
    }

    public static <R> LoggingMonad<R> unit(R value) {
        return new LoggingMonad<>(value, Lists.newArrayList());
    }

    public static <T1, T2> LoggingMonad<T2> bind(LoggingMonad<T1> input, Function<T1, LoggingMonad<T2>> transform) {
        final LoggingMonad<T2> result = transform.apply(input.value);
        List<String> logs = new ArrayList<>(input.logs);
        logs.addAll(result.logs);
        return new LoggingMonad<>(result.value, logs);
    }

    public static <R> LoggingMonad<R> pipeline(LoggingMonad<R> monad, List<Function<R, LoggingMonad<R>>> transforms) {
        LoggingMonad<R> result = monad;
        for (Function<R, LoggingMonad<R>> transform : transforms) {
            result = bind(result, transform);
        }
        return result;
    }

    public static void main(String[] args) {
        Function<Integer, LoggingMonad<Integer>> transform1 = v -> new LoggingMonad<>(v * 4,
                                                                                      Lists.newArrayList(v + "*4"));
        Function<Integer, LoggingMonad<Integer>> transform2 = v -> new LoggingMonad<>(v / 2,
                                                                                      Lists.newArrayList(v + "/2"));
        final LoggingMonad<Integer> result = pipeline(LoggingMonad.unit(8), Lists.newArrayList(transform1, transform2));
        System.out.println(result);

    }
}
