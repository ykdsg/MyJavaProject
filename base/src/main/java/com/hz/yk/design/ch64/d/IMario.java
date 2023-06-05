package com.hz.yk.design.ch64.d;

/**
 * @author wuzheng.yk
 * @date 2023/4/24
 */

import com.hz.yk.design.ch64.State;

/**
 * 所有状态类的接口
 */
public interface IMario {

    State getName();

    //以下是定义的事件
    void obtainMushRoom(MarioStateMachine stateMachine);

    void obtainCape(MarioStateMachine stateMachine);

    void obtainFireFlower(MarioStateMachine stateMachine);

    void meetMonster(MarioStateMachine stateMachine);
}
