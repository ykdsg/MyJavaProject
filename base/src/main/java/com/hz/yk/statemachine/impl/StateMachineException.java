package com.hz.yk.statemachine.impl;

/**
 * @author wuzheng.yk
 * @date 2021/1/31
 */
public class StateMachineException extends RuntimeException {

    private static final long serialVersionUID = 2116795885436862986L;

    public StateMachineException(String message) {
        super(message);
    }
}
