package com.hz.yk.design.ch64.d;

/**
 * @author wuzheng.yk
 * @date 2023/4/24
 */
public class MarioStateMachine {

    private int score;
    private IMario mario;   // 不再使用枚举来表示状态

    public MarioStateMachine() {
        this.score = 0;
        this.mario = SmallMario.getInstance();
    }

    public void obtainMushRoom() {
        mario.obtainMushRoom(this);
    }

    public void obtainCape() {
        mario.obtainCape(this);
    }

    public void obtainFireFlower() {
        mario.obtainFireFlower(this);
    }

    public void meetMonster() {
        mario.meetMonster(this);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public IMario getMario() {
        return mario;
    }

    public void setMario(IMario mario) {
        this.mario = mario;
    }
}
