package com.hz.yk.statemachine.builder;

/**
 * @author wuzheng.yk
 * @date 2021/2/1
 */
public class StateMachineBuilderFactory {

    public static <S, E, C> StateMachineBuilder<S, E, C> create() {
        return new StateMachineBuilderImpl<>();
    }
}
