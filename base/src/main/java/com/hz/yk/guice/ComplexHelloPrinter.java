package com.hz.yk.guice;

/**
 * @author wuzheng.yk
 * @date 2020/8/27
 */
public class ComplexHelloPrinter implements IHelloPrinter {

    @Override
    public void print() {

        System.out.println("hello,complex world");
    }
}
