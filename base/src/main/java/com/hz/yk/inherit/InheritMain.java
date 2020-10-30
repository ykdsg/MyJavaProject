package com.hz.yk.inherit;

/**
 * 如果父类的静态字段是子类对象，调用顺序有点奇怪
 * 父类构造函数
 * 子类构造函数
 * 父类静态块
 * 子类静态块
 * 父类构造函数
 * 子类构造函数
 *
 * @author wuzheng.yk
 * @date 2020/10/30
 */
public class InheritMain {

    public static void main(String[] args) {
        final Son son = new Son();
        son.call();
    }

}
