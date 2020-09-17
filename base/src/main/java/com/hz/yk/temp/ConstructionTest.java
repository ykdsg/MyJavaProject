package com.hz.yk.temp;

/**
 * 静态变量和静态代码块的执行顺序
 *
 * @author wuzheng.yk
 * @date 2020/8/19
 */
public class ConstructionTest {

    public static ConstructionTest2 t1 = new ConstructionTest2();
    public static ConstructionTest2 t2 = new ConstructionTest2();
    public static ConstructionTest t0 = new ConstructionTest();

    {
        System.out.println("构造块");
    }

    static {
        System.out.println("静态块");
    }

    public static void main(String[] args) {
        ConstructionTest test = new ConstructionTest();
    }
}
