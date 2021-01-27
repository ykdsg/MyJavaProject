package com.hz.yk.ddd.demo4.ecs.entity;

/**
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public class Transform {

    public static final Transform ORIGIN = new Transform(0, 0);
    long x;
    long y;

    public Transform(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }
}
