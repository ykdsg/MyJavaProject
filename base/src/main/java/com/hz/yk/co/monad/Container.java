package com.hz.yk.co.monad;

import com.hz.yk.co.monad.component.Component;

/**
 * Created by wuzheng.yk on 16/12/8.
 */
public interface Container {

    Component getComponent(Object key);
    Component getComponentOfType(Class type);
}
