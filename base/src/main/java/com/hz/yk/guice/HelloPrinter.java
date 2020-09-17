package com.hz.yk.guice;

/**
 * @author wuzheng.yk
 * @date 2020/8/27
 */
public class HelloPrinter implements IHelloPrinter {

    @Override
    public void print() {
        System.out.println("hello,world");
    }

}
