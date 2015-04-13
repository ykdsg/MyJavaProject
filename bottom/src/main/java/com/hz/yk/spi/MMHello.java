package com.hz.yk.spi;

/**
 * 具体的实现可以和META-INF 中的com.hz.yk.spi.HelloInterface 配置放到外部的jar中
 * @author wuzheng.yk
 *         Date: 15/4/13
 *         Time: 20:10
 */
public class MMHello implements HelloInterface{
    @Override
    public void sayHi() {
        System.out.println("mm say hi");
    }
}
