package com.hz.yk.jmx.hello;

/**
 * Created by wuzheng.yk on 2017/12/7.
 */
public interface HelloMBean {

    public String getName();

    public void setName(String name);

    public void printHello();

    public void printHello(String whoName);

}
