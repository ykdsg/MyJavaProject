package com.hz.yk.spi;

/**
 * @author wuzheng.yk
 *         Date: 15/4/13
 *         Time: 20:09
 */
public class PikaHello implements HelloInterface{
    @Override
    public void sayHi() {
        System.out.println("pika say hi");
    }
}
