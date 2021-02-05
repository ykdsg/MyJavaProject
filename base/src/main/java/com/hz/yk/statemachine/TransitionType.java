package com.hz.yk.statemachine;

/**
 * @author wuzheng.yk
 * @date 2021/1/31
 */
public enum TransitionType {

    /**
     * 内部流转，同一个状态之间的流转
     */
    INTERNAL,
    /**
     * 外部流转，两个不同状态之间的流转
     */
    EXTERNAL
}
