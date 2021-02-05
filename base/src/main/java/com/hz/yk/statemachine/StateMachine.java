package com.hz.yk.statemachine;

/**
 * @author wuzheng.yk
 * @date 2021/1/31
 */
public interface StateMachine<S, E, C> {

    /**
     * 发送事件event，返回目标state
     *
     * @param sourceSate
     * @param event
     * @param ctx
     * @return
     */
    S fireEvent(S sourceSate, E event, C ctx);

    String getMachineId();

    /**
     * Use visitor pattern to display the structure of the state machine
     */
    void showStateMachine();

    String generatePlantUML();

}
