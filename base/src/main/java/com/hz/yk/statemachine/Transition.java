package com.hz.yk.statemachine;

/**
 * @author wuzheng.yk
 * @date 2021/1/31
 */
public interface Transition<S, E, C> {

    /**
     * 执行从源状态到目标状态的转换
     *
     * @param ctx
     * @return
     */
    State<S, E, C> transit(C ctx);

    /**
     * 校验流转的正确性
     */
    void verify();

    /**
     * 本次转换的源状态
     *
     * @return
     */
    State<S, E, C> getSource();

    void setSource(State<S, E, C> state);

    E getEvent();

    void setEvent(E event);

    void setType(TransitionType type);

    /**
     * Gets the target state of this transition.
     *
     * @return the target state
     */
    State<S, E, C> getTarget();

    void setTarget(State<S, E, C> state);

    /**
     * Gets the guard of this transition.
     *
     * @return the guard
     */
    Condition<C> getCondition();

    void setCondition(Condition<C> condition);
}
