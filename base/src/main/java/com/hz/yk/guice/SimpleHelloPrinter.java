package com.hz.yk.guice;

import com.google.inject.Singleton;

/**
 * @author wuzheng.yk
 * @date 2020/8/27
 */
@Singleton
public class SimpleHelloPrinter implements IHelloPrinter {

    @Override
    public void print() {
        System.out.println("hello, simple world");
    }
}
