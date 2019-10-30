package com.hz.yk.functor;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author wuzheng.yk
 * @date 2019/10/25
 */
public class MList<T> implements Monad<T, MList<?>> {

    private final ImmutableList<T> list;

    public MList(Iterable<T> value) {
        this.list = ImmutableList.copyOf(value);
    }

    @Override
    public <R> MList<R> map(Function<T, R> f) {
        List<R> result = new ArrayList<R>(list.size());
        for (T t : list) {
            result.add(f.apply(t));
        }
        return new MList<>(result);
    }

    public MList<?> flatMap2(Function<T, MList<?>> f) {
        List<MList<?>> mResult = new ArrayList<>(list.size());
        for (T t : list) {
            mResult.add(f.apply(t));
        }
        List result = new ArrayList<>(list.size());
        for (MList<?> mList : mResult) {
            result.addAll(mList.list);
        }
        return new MList<>(result);
    }

    @Override
    public MList<?> flatMap(Function<T, MList<?>> f) {
        return null;
    }

}
