package com.hz.yk.yk.reflect.param;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Method.getParameters为1.8新增方法，可以获取参数信息，包括参数名称。
 * 保留参数名这一选项由编译开关javac -parameters打开，默认是关闭的。
 * 在实际使用中会大打折扣
 * Created by wuzheng.yk on 16/1/29.
 */
public class GetParamNamesByJava8 {
    public static void main(String[] args) throws NoSuchMethodException {
        Method m = Demo.class.getMethod("add", int.class, int.class);
        System.out.println("method :" + m.getName());
        System.out.println("return :" + m.getReturnType().getName());
        for (Parameter p : m.getParameters()) {
            System.out.println("parameter :" + p.getType().getName() + "," + p.getName());
        }
    }
}
