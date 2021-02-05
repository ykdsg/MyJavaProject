package com.hz.yk.statemachine.impl;

import com.hz.yk.statemachine.State;
import com.hz.yk.statemachine.Transition;
import com.hz.yk.statemachine.TransitionType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

/**
 * @author wuzheng.yk
 * @date 2021/1/31
 */
public class StateImpl<S, E, C> implements State<S, E, C> {

    protected final S stateId;
    private final HashMap<E, Transition<S, E, C>> transitions = new HashMap<>();

    public StateImpl(S stateId) {
        this.stateId = stateId;
    }

    @Override
    public S getId() {
        return stateId;
    }

    @Override
    public Transition<S, E, C> addTransition(E event, State<S, E, C> target, TransitionType transitionType) {
        Transition<S, E, C> newTransition = new TransitionImpl<S, E, C>();
        newTransition.setSource(this);
        newTransition.setTarget(target);
        newTransition.setEvent(event);
        newTransition.setType(transitionType);

        verify(event, newTransition);
        transitions.put(event, newTransition);
        return newTransition;
    }

    @Override
    public Optional<Transition<S, E, C>> getTransition(E event) {
        return Optional.empty();
    }

    @Override
    public Collection<Transition<S, E, C>> getTransitions() {
        return null;
    }

    /**
     * Per one source and target state, there is only one transition is allowed
     *
     * @param event
     * @param newTransition
     */
    private void verify(E event, Transition<S, E, C> newTransition) {
        Transition<S, E, C> existingTransition = transitions.get(event);
        if (existingTransition != null) {
            if (existingTransition.equals(newTransition)) {
                throw new StateMachineException(existingTransition + " already Exist, you can not add another one");
            }
        }
    }
}
