package com.hz.yk.statemachine.impl;

import com.hz.yk.statemachine.State;
import com.hz.yk.statemachine.StateMachine;
import com.hz.yk.statemachine.Transition;

import java.util.Map;
import java.util.Optional;

/**
 * @author wuzheng.yk
 * @date 2021/1/31
 */
public class StateMachineImpl<S, E, C> implements StateMachine<S, E, C> {

    private final Map<S, State<S, E, C>> stateMap;

    private String machineId;

    private boolean ready;

    public StateMachineImpl(Map<S, State<S, E, C>> stateMap) {this.stateMap = stateMap;}

    @Override
    public S fireEvent(S sourceStateId, E event, C ctx) {
        isReady();
        State<S, E, C> sourceState = getState(sourceStateId);
        return doTransition(sourceState, event, ctx).getId();
    }

    private State<S, E, C> doTransition(State<S, E, C> sourceState, E event, C ctx) {
        final Optional<Transition<S, E, C>> transition = sourceState.getTransition(event);
        if (transition.isPresent()) {
            return transition.get().transit(ctx);
        }
        return sourceState;
    }

    @Override
    public String getMachineId() {
        return machineId;
    }

    private void isReady() {
        if (!ready) {
            throw new StateMachineException("State machine is not built yet, can not work");
        }
    }

    private State<S, E, C> getState(S currentStateId) {
        State<S, E, C> state = StateHelper.getState(stateMap, currentStateId);
        if (state == null) {
            showStateMachine();
            throw new StateMachineException(currentStateId + " is not found, please check state machine");
        }
        return state;
    }

    @Override
    public void showStateMachine() {

    }

    @Override
    public String generatePlantUML() {
        return null;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
}
