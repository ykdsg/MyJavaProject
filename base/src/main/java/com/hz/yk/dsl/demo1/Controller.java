package com.hz.yk.dsl.demo1;

/**
 * @author wuzheng.yk
 * @date 2021/4/17
 */
public class Controller {

    private State currentState;
    private StateMachine machine;
    private CommandChannel commandChannel;

    /**
     * 从设备接收到的事件代码为参数
     * @param eventCode
     */
    public void handle(String eventCode) {
        if (currentState.hasTransition(eventCode)) {
            transitionTo(currentState.targetState(eventCode));
        } else if (machine.isResetEvent(eventCode)) {
            transitionTo(machine.getStart());
        }
    }

    private void transitionTo(State target) {
        currentState = target;
        currentState.executeActions(commandChannel);
    }
}
