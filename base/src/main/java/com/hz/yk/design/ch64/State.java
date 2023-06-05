package com.hz.yk.design.ch64;

/**
 * @author wuzheng.yk
 * @date 2023/4/24
 */
public enum State {
    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);

    private final int value;

    private State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
