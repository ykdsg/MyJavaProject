package com.hz.yk.design.ch64.b;

import com.hz.yk.design.ch64.State;

/**
 * @author wuzheng.yk
 * @date 2023/4/24
 */
public class ApplicationDemo {

    public static void main(String[] args) {
        MarioStateMachine mario = new MarioStateMachine();
        mario.obtainMushRoom();
        int score = mario.getScore();
        State currentState = mario.getCurrentState();
        System.out.println("mario score: " + score + "; state: " + currentState);
    }

}
