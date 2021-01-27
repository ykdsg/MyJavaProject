package com.hz.yk.ddd.demo4.ecs.entity;

/**
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public class Vector {

    public static final Vector ZERO = new Vector(0, 0);
    long x;
    long y;

    public Vector(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
}
