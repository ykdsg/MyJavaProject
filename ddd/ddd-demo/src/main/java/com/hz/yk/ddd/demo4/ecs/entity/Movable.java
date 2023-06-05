package com.hz.yk.ddd.demo4.ecs.entity;

/**
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public interface Movable {

    // 相当于组件
    Transform getPosition();

    Vector getVelocity();

    // 行为
    void moveTo(long x, long y);

    void startMove(long velX, long velY);

    void stopMove();

    boolean isMoving();

}
