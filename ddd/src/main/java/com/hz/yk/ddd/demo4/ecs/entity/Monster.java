package com.hz.yk.ddd.demo4.ecs.entity;

/**
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public class Monster implements Movable {

    private MonsterId id;
    private MonsterClass monsterClass; // enum
    private Health health;
    private Transform position = Transform.ORIGIN;
    private Vector velocity = Vector.ZERO;

    @Override
    public Transform getPosition() {
        return position;
    }

    @Override
    public Vector getVelocity() {
        return velocity;
    }

    @Override
    public void moveTo(long x, long y) {
        this.position = new Transform(x, y);
    }

    @Override
    public void startMove(long velX, long velY) {
        this.velocity = new Vector(velX, velY);
    }

    @Override
    public void stopMove() {
        this.velocity = Vector.ZERO;
    }

    @Override
    public boolean isMoving() {
        return this.velocity.getX() != 0 || this.velocity.getY() != 0;
    }

    public MonsterId getId() {
        return id;
    }

    public MonsterClass getMonsterClass() {
        return monsterClass;
    }

    public Health getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        
    }
}
