package com.hz.yk.javassist;

/**
 * 表示没有默认构造函数的类
 *
 * @author wuzheng.yk
 * @date 2021/4/15
 */
public class NoDefaultConstructor {

    String name;

    public NoDefaultConstructor(String name) {
        this.name = name;
    }

    public void method1() {
        System.out.println("run method1");
    }
}
