package com.hz.yk.design.ch64.d;

import com.hz.yk.design.ch64.State;

/**
 * @author wuzheng.yk
 * @date 2023/4/24
 */
public class SuperMario implements IMario {

    private static final SuperMario stateMachine = new SuperMario();

    public static SuperMario getInstance() {
        return stateMachine;
    }

    private SuperMario() {
    }

    @Override
    public State getName() {
        return State.SUPER;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {

    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        stateMachine.setMario(CapeMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 200);
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        stateMachine.setMario(FireMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 300);
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setMario(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 100);
    }
}
