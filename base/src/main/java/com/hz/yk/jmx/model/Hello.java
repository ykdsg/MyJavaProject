package com.hz.yk.jmx.model;

/**
 * Created by wuzheng.yk on 2017/12/8.
 */
public class Hello {//注意这里没有implements任何东西
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Hello world, " + name);
    }

    public void printHello(String whoName) {
        System.out.println("Hello, " + whoName);
    }

}
