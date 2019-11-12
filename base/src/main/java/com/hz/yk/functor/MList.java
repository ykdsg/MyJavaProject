package com.hz.yk.functor;

import com.google.common.collect.ImmutableList;
import com.hz.yk.stack.T1;
import com.hz.yk.stack.T2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
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

    @Override
    public <R> MList<R> flatMap(Function<T, MList<?>> f) {
        List<MList<R>> mResult = new ArrayList<>(list.size());
        for (T t : list) {
            mResult.add((MList<R>) f.apply(t));
        }
        List<R> result = new ArrayList<>(list.size());
        for (MList<R> mList : mResult) {
            result.addAll(mList.list);
        }
        return new MList<>(result);
    }

    <R> MList<R> liftM2(MList<T1> t1, MList<T2> t2, BiFunction<T1, T2, R> fun) {
        return t1.flatMap((T1 tv1) -> t2.map((T2 tv2) -> fun.apply(tv1, tv2)));
    }

}
