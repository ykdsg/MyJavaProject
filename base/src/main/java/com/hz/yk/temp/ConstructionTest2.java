package com.hz.yk.temp;

/**
 * 静态变量和静态代码块的执行顺序
 *
 * @author wuzheng.yk
 * @date 2020/8/19
 */
public class ConstructionTest2 {

    public static ConstructionTest t1 = new ConstructionTest();

    {
        System.out.println("构造块2");
    }

    static {
        System.out.println("静态块2");
    }

    public static void main(String[] args) {
        ConstructionTest2 test = new ConstructionTest2();
    }
}
