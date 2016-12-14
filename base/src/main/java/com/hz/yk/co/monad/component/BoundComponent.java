package com.hz.yk.co.monad.component;

import com.hz.yk.co.monad.Dependency;

/**
 * Created by wuzheng.yk on 16/12/11.
 */
public class BoundComponent implements Component{

    private final Component c;
    private final Binder binder;

    public BoundComponent(Component c, Binder binder) {
        this.c = c;
        this.binder = binder;
    }

    @Override
    public Class getType() {
        return null;
    }

    @Override
    public Object create(Dependency dep) {
        return binder.bind(c.create(dep)).create(dep);
    }

    @Override
    public Class verify(Dependency dep) {
        c.verify(dep);
        return Object.class;
    }
}
