package com.hz.yk.statemachine.builder;

import com.hz.yk.statemachine.State;
import com.hz.yk.statemachine.StateMachine;
import com.hz.yk.statemachine.TransitionType;
import com.hz.yk.statemachine.impl.StateMachineImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuzheng.yk
 * @date 2021/2/1
 */
public class StateMachineBuilderImpl<S, E, C> implements StateMachineBuilder<S, E, C> {

    private final Map<S, State<S, E, C>> stateMap = new ConcurrentHashMap<>();

    private final StateMachineImpl<S, E, C> stateMachine = new StateMachineImpl<>(stateMap);

    @Override
    public ExternalTransitionBuilder<S, E, C> externalTransition() {
        return new TransitionBuilderImpl<>(stateMap, TransitionType.EXTERNAL);
    }

    @Override
    public StateMachine<S, E, C> build(String machineId) {
        stateMachine.setMachineId(machineId);
        stateMachine.setReady(true);
        StateMachineFactory.register(stateMachine);
        return stateMachine;
    }
}
