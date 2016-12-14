package com.hz.yk.co.monad.component;

import com.hz.yk.co.monad.Dependency;

/**
 * Created by wuzheng.yk on 16/12/11.
 */
public class SingletonComponent implements Component {

    private final Component c;
    private Object          val;

    public SingletonComponent(Component c){
        this.c = c;
    }

    @Override
    public Class getType() {
        return c.getType();
    }

    @Override
    public Object create(Dependency dep) {
        if (val != null) {
            return val;
        }
        val = c.create(dep);
        return val;
    }

    @Override
    public Class verify(Dependency dep) {
        if (val != null) {
            return val.getClass();
        }

        else return c.verify(dep);
    }
}
