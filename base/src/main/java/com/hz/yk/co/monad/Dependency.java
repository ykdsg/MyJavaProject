package com.hz.yk.co.monad;

/**
 * Dependency接口由每个不同的组件调用，来解决依赖。如果解析失败，则抛出异常。此处，我们暂时忽略异常这个细节
 * Created by wuzheng.yk on 16/12/8.
 */
public interface Dependency {

    /**
     * getArgument负责解析一个函数参数，组件告诉Dependency对象，我需要给第3个参数，类型为String的解析依赖。于是就调用
     getArgument(2, String.class)
     * @param i
     * @param type
     * @return
     */
    Object getArgument(int i, Class type);

    /**
     * getProperty负责解析一个用某个key来标识的属性。比如一个javabean的property。
     * @param key
     * @param type
     * @return
     */
    Object getProperty(Object key, Class type);



    /**
     * 只取得解析到的那个符合要求的组件类型，但是并不实际创建对象
     * @param i
     * @param type
     * @return
     */
    Class verifyArgument(int i, Class type);

    /**
     * 只取得解析到的那个符合要求的组件类型，但是并不实际创建对象
     * @param key
     * @param type
     * @return
     */
    Class verifyProperty(Object key, Class type);
}
