package com.hz.yk.co.monad;

/**
 * 表示构造函数和工厂方法
 * Created by wuzheng.yk on 16/12/8.
 */
public interface Function {
    Class getReturnType();
    Class[] getParameterTypes();
    Object call(Object[] args);
}
