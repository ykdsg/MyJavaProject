package com.hz.yk.design.ch64.c;

import com.hz.yk.design.ch64.State;

/**
 * @author wuzheng.yk
 * @date 2023/4/24
 */
public class FireMario implements IMario {

    private MarioStateMachine stateMachine;

    public FireMario(MarioStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public State getName() {
        return State.FIRE;
    }

    @Override

    public void obtainMushRoom() {
        // do nothing...
    }

    @Override
    public void obtainCape() {
        // do nothing...
    }

    @Override
    public void obtainFireFlower() {
        // do nothing...
    }

    @Override
    public void meetMonster() {
        stateMachine.setMario(new SmallMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() - 300);
    }

}
