package com.hz.yk.masterworker;

/**
 * Created by wuzheng.yk on 17/3/13.
 */
public class PlusWorker extends Worker {

    /**
     * 求立方和
     */
    @Override
    public Object handle(Object input) {
        Integer i = (Integer) input;
        return i * i * i;
    }
}
