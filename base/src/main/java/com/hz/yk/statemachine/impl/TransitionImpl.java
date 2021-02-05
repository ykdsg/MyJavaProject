package com.hz.yk.statemachine.impl;

import com.hz.yk.statemachine.Action;
import com.hz.yk.statemachine.Condition;
import com.hz.yk.statemachine.State;
import com.hz.yk.statemachine.Transition;
import com.hz.yk.statemachine.TransitionType;

/**
 * @author wuzheng.yk
 * @date 2021/1/31
 */
public class TransitionImpl<S, E, C> implements Transition<S, E, C> {

    private State<S, E, C> source;
    private State<S, E, C> target;
    private E event;

    private Condition<C> condition;

    private Action<S, E, C> action;
    private TransitionType type = TransitionType.EXTERNAL;

    @Override
    public State<S, E, C> transit(C ctx) {
        this.verify();
        if (condition == null || condition.isSatisfied(ctx)) {
            if (action != null) {
                action.execute(source.getId(), target.getId(), event, ctx);
            }
            return target;
        }

        return source;
    }

    @Override
    public void verify() {
        if (type == TransitionType.INTERNAL && source != target) {
            throw new StateMachineException(
                    String.format("Internal transition source state '%s' " + "and target state '%s' must be same.",
                                  source, target));
        }
    }

    @Override
    public State<S, E, C> getSource() {
        return source;
    }

    @Override
    public void setSource(State<S, E, C> state) {
        this.source = state;
    }

    @Override
    public E getEvent() {
        return event;
    }

    @Override
    public void setEvent(E event) {
        this.event = event;
    }

    @Override
    public void setType(TransitionType type) {
        this.type = type;
    }

    @Override
    public State<S, E, C> getTarget() {
        return target;
    }

    @Override
    public void setTarget(State<S, E, C> state) {
        this.target = state;
    }

    @Override
    public Condition<C> getCondition() {
        return this.condition;
    }

    @Override
    public void setCondition(Condition<C> condition) {
        this.condition = condition;
    }

    @Override
    public final String toString() {
        return source + "-[" + event.toString() + ", " + type + "]->" + target;
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject instanceof Transition) {
            Transition<S, E, C> other = (Transition<S, E, C>) anObject;
            if (this.event.equals(other.getEvent()) && this.source.equals(other.getSource()) && this.target
                    .equals(other.getTarget())) {
                return true;
            }
        }
        return false;
    }
}
