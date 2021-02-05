package com.hz.yk.statemachine.impl;

import com.hz.yk.statemachine.State;

import java.util.Map;

/**
 * @author wuzheng.yk
 * @date 2021/1/31
 */
public class StateHelper {

    public static <S, E, C> State<S, E, C> getState(Map<S, State<S, E, C>> stateMap, S stateId) {
        State<S, E, C> state = stateMap.get(stateId);
        if (state == null) {
            state = new StateImpl<S, E, C>(stateId);
            stateMap.put(stateId, state);
        }
        return state;
    }
}
