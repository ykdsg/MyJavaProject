package com.hz.yk.dsl.demo1;

/**
 * @author wuzheng.yk
 * @date 2021/4/17
 */
public class Transition {

    private final State source, target;

    private final Event trigger;

    public Transition(State source, State target, Event trigger) {
        this.source = source;
        this.target = target;
        this.trigger = trigger;
    }

    public State getSource() {
        return source;
    }

    public State getTarget() {
        return target;
    }

    public Event getTrigger() {
        return trigger;
    }
}
