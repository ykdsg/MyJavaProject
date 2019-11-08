package com.hz.yk.functor.monad;

/**
 * @author wuzheng.yk
 * @date 2019/10/31
 */
public class State {

    private final int value;

    public State(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "State{" + "value=" + value + '}';
    }
}
