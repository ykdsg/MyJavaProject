package com.hz.yk.yk.type;

import java.util.List;

/**
 * Created by wuzheng.yk on 16/1/18.
 */
public class GenericClass extends BaseGeneircInteface<List> implements GeneircInteface<List>,CommonInteface{

    @Override
    public List method1(List obj) {
        result = obj;
        return result;
    }


    @Override
    public Integer method2(Integer obj) {
        return null;
    }

    public <T extends Object,E extends Throwable> T method3(T obj) throws E {
        return obj;
    }
}
