package com.hz.yk.co.monad.component;

import com.hz.yk.co.monad.Dependency;

/**
 * Created by wuzheng.yk on 16/12/11.
 */
public class MapComponent implements Component {

    private final Component c;
    private final Map       map;

    public MapComponent(Component c, Map map){
        this.c = c;
        this.map = map;
    }

    /**
     * 这里，因为我们无法预先知道Map这个接口返回的对象会是什么类型，所以，我们让getType()返回null来标示这是一个动态决定的组件类型。
     * @return
     */
    @Override
    public Class getType() {
        return null;
    }

    @Override
    public Object create(Dependency dep) {
        return map.map(c.create(dep));
    }

    @Override
    public Class verify(Dependency dep) {
        c.verify(dep);
        return Object.class;
    }
}
