package com.hz.yk.co.monad.component;

/**
 * map是一个相当有用的组合规则。它负责把一个Component返回的对象作一下额外的处理，transform成另外一个对象。
 * Created by wuzheng.yk on 16/12/11.
 */
public interface Map {
    Object map(Object obj);
}
