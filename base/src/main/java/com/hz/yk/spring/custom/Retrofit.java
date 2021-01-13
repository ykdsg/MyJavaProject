package com.hz.yk.spring.custom;

/**
 * Created by wuzheng.yk on 16/9/9.
 */
public class Retrofit {

    /**
     * 模拟通过RPC等方法获取bean
     *
     * @param clazz
     * @return
     * @throws IllegalAccessException
     */
    public Object create(Class clazz) throws IllegalAccessException {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
