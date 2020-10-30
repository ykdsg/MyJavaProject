package com.hz.yk.inherit;

/**
 * @author wuzheng.yk
 * @date 2020/10/30
 */
public class Son extends Parent {

    static String name;

    static {
        System.out.println("static son");
        name = "jack";
    }

    public Son() {
        System.out.println("construct son");
    }

    public void call() {
        System.out.println("hello~~~~~~~~");
    }

    public static String getName() {
        return name;
    }
}
