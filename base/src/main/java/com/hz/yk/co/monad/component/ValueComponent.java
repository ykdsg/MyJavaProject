package com.hz.yk.co.monad.component;

import com.hz.yk.co.monad.Dependency;

/**
 * Created by wuzheng.yk on 16/12/8.
 */
public class ValueComponent implements Component {
    private Object v;

    @Override
    public Class getType() {
        return v==null?null:v.getClass();
    }

    @Override
    public Object create(Dependency dep) {
        return v;
    }

    @Override
    public Class verify(Dependency dep) {
        return getType();
    }
}
