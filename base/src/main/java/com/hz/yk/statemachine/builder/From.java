package com.hz.yk.statemachine.builder;

/**
 * @author wuzheng.yk
 * @date 2021/2/1
 */
public interface From<S, E, C> {

    To<S, E, C> to(S stateId);

}
