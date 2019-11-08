package com.hz.yk.functor.monad;

/**
 * @author wuzheng.yk
 * @date 2019/10/30
 */
public class Environment {

    public String getPrefix() {
        return "$$";
    }

    public int getBase() {
        return 100;
    }
}
