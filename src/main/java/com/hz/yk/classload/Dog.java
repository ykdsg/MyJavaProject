package com.hz.yk.classload;

/**
 * @author wuzheng.yk
 *         Date: 15/1/29
 *         Time: 11:06
 */
public class Dog {
    public Dog(){
        System.out.println("我是dog,我被："+this.getClass().getClassLoader()+"   加载了");
    }
}
