package com.hz.yk.design.ch64.c;

/**
 * @author wuzheng.yk
 * @date 2023/4/24
 */
public class ApplicationDemo {

    public static void main(String[] args) {
        MarioStateMachine mario = new MarioStateMachine();
        mario.obtainMushRoom();
        int score = mario.getScore();
        IMario mario1 = mario.getMario();
        System.out.println("mario score: " + score + "; state: " + mario1.getName());
    }
}
