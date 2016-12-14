package com.hz.yk.co.monad;

import org.apache.commons.lang.IllegalClassException;

/**
 * Created by wuzheng.yk on 16/12/8.
 */
public class Util {

    public static void checkTypeMatch(Class clazz1, Class clazz2) {
        if (clazz1 != clazz2) {
            throw new IllegalClassException("class 校验不通过");
        }
    }
}
