package com.hz.yk.inherit;

/**
 * @author wuzheng.yk
 * @date 2020/10/30
 */
public class Parent {

    static Son son = new Son();

    static {
        System.out.println("static parent");

    }

    public Parent() {
        System.out.println("construct parent");
        System.out.println("son name is null :" + (Son.getName() == null));
        System.out.println("```````");
    }
}
