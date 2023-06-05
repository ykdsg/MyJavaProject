package com.hz.yk.design.ch64.d;

import com.hz.yk.design.ch64.State;

/**
 * @author wuzheng.yk
 * @date 2023/4/24
 */
public class FireMario implements IMario {

    private static final FireMario stateMachine = new FireMario();

    public static FireMario getInstance() {
        return stateMachine;
    }

    private FireMario() {

    }

    @Override
    public State getName() {
        return State.FIRE;
    }

    @Override

    public void obtainMushRoom(MarioStateMachine stateMachine) {
        // do nothing...
    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        // do nothing...
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        // do nothing...
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setMario(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 300);
    }

}
