package com.hz.yk.disruptor;

/**
 * Created by wuzheng.yk on 2017/8/24.
 */
public class ObjectEvent {

    private Object object;

    public Object getObject() {
        return object;
    }

    public ObjectEvent setObject(Object object) {
        this.object = object;
        return this;
    }
}
