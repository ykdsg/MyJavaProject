package com.hz.yk.javassist;

/**
 * @author wuzheng.yk
 * @date 2021/4/15
 */
public class SubClass extends NoDefaultConstructor {

    public SubClass() {
        super("");
    }

    public SubClass(String name) {
        super(name);
    }
}
