package com.hz.yk.co.monad.component;

import com.hz.yk.co.monad.Dependency;

/**
 * Created by wuzheng.yk on 16/12/8.
 */
public interface Component {
    /**
     * 返回这个Component生成的对象的类型
     * @return
     */
    Class getType();

    /**
     * 创建这个对象
     * @param dep
     * @return
     */
    Object create(Dependency dep);

    /**
     * 保证这个对象可以被创建
     * @param dep
     * @return
     */
    Class verify(Dependency dep);

}
