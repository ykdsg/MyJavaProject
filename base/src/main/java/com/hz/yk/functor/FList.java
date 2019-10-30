package com.hz.yk.functor;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * API保持不变:在一个转换T -> R中使用一个函子，但是行为有很大的不同。现在，我们对FList中的每一项应用一个转换，声明性地转换整个列表。
 *
 * @author wuzheng.yk
 * @date 2019/10/25
 */
public class FList<T> implements Functor<T, FList<?>> {

    private final ImmutableList<T> list;

    public FList(Iterable<T> value) {
        this.list = ImmutableList.copyOf(value);
    }

    @Override
    public <R> FList<R> map(Function<T, R> f) {
        List<R> result = new ArrayList<R>(list.size());
        for (T t : list) {
            result.add(f.apply(t));
        }
        return new FList<>(result);
    }

}
