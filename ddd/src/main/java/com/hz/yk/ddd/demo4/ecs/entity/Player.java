package com.hz.yk.ddd.demo4.ecs.entity;

import com.hz.yk.ddd.demo4.ecs.domain.EquipmentService;

/**
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public class Player implements Movable {

    private PlayerId id;
    private String name;
    private PlayerClass playerClass; // enum
    private WeaponId weaponId; // （Note 1）
    private Transform position = Transform.ORIGIN;
    private Vector velocity = Vector.ZERO;

    /**
     * 在DDD里，一个Entity不应该直接参考另一个Entity或服务，正确的引用方式是通过方法参数引入
     *
     * @param weapon
     * @param equipmentService
     */
    public void equip(Weapon weapon, EquipmentService equipmentService) {
        if (equipmentService.canEquip(this, weapon)) {
            this.weaponId = weapon.getId();
        } else {
            throw new IllegalArgumentException("Cannot Equip: " + weapon);
        }
    }

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
    public void startMove(long velocityX, long velocityY) {
        this.velocity = new Vector(velocityX, velocityY);
    }

    @Override
    public void stopMove() {
        this.velocity = Vector.ZERO;
    }

    @Override
    public boolean isMoving() {
        return this.velocity.getX() != 0 || this.velocity.getY() != 0;
    }

    public PlayerId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    public WeaponId getWeaponId() {
        return weaponId;
    }
}
