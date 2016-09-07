package com.hz.yk.type;

/**
 * Created by wuzheng.yk on 16/1/18.
 */
public class BaseGeneircInteface<R> implements GeneircInteface<R> {

    protected R result;

    @Override
    public R method1(R obj) {
        return obj;
    }

}