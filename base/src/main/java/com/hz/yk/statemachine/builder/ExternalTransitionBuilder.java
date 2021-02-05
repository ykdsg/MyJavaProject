package com.hz.yk.statemachine.builder;

/**
 * @author wuzheng.yk
 * @date 2021/2/1
 */
public interface ExternalTransitionBuilder<S, E, C> {

    From<S, E, C> from(S stateId);
}
