package com.hz.yk.functor.monad;

/**
 * @author wuzheng.yk
 * @date 2019/10/30
 */
public class Demo1 {

    int count = 0;

    /**
     * 包含副作用的函数
     *
     * @param x
     * @return
     */
    int increase(int x) {
        count++;
        return x + 1;
    }
}
