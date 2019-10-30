package com.hz.yk.functor;

import java.util.function.Function;

/**
 * @author wuzheng.yk
 * @date 2019/10/25
 */
public class FOptional<T> implements Functor<T, FOptional<?>> {

    private final T valueOrNull;

    public FOptional(T valueOrNull) {
        this.valueOrNull = valueOrNull;
    }

    @Override
    public <R> FOptional<R> map(Function<T, R> f) {
        if (valueOrNull == null) {
            return empty();
        } else {
            return of(f.apply(valueOrNull));
        }
    }

    public static <T> FOptional<T> of(T a) {
        return new FOptional<>(a);
    }

    public static <T> FOptional<T> empty() {
        return new FOptional<T>(null);
    }

    FOptional<Integer> tryParse(String s) {
        try {
            final int i = Integer.parseInt(s);
            return FOptional.of(i);
        } catch (NumberFormatException e) {
            return FOptional.empty();
        }
    }
}
