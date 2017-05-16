package com.hz.yk.asm5.example1;

/**
 * 要修改的方法中，准备添加的我们自己的代码逻辑
 * Created by wuzheng.yk on 17/5/12.
 */
public class AopInteceptor {
    public static void before(){
        System.out.println(".......before().......");
    }

    public static void after(){
        System.out.println(".......after().......");
    }
}
