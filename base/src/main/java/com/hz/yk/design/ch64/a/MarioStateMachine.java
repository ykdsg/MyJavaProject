package com.hz.yk.design.ch64.a;

import com.hz.yk.design.ch64.State;

/**
 * @author wuzheng.yk
 * @date 2023/4/24
 */
public class MarioStateMachine {

    private int score;

    private State currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushRoom() {
        if (this.currentState == State.SMALL) {
            this.currentState = State.SUPER;
            this.score += 100;
        }
    }

    public void obtainCape() {
        if (this.currentState == State.SMALL) {
            this.currentState = State.CAPE;
            this.score += 200;
        } else if (this.currentState == State.SUPER) {
            this.currentState = State.CAPE;
            this.score += 200;
        }
    }

    public void obtainFireFlower() {
        if (this.currentState == State.SMALL) {
            this.currentState = State.FIRE;
            this.score += 300;
        } else if (this.currentState == State.SUPER) {
            this.currentState = State.FIRE;
            this.score += 300;
        }
    }

    public void meetMonster() {
        if (this.currentState == State.SUPER) {
            this.currentState = State.SMALL;
            this.score -= 100;
        } else if (this.currentState == State.CAPE) {
            this.currentState = State.SMALL;
            this.score -= 200;
        } else if (this.currentState == State.FIRE) {
            this.currentState = State.SMALL;
            this.score -= 300;
        }
    }

    public int getScore() {
        return score;
    }

    public State getCurrentState() {
        return currentState;
    }

}
