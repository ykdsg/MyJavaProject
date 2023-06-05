package com.hz.yk.ddd.demo4.ecs.entity;

/**
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public class Weapon {

    private WeaponId id;
    private String name;
    private WeaponType weaponType; // enum
    private int damage;
    private int damageType; // 0 - physical, 1 - fire, 2 - ice

    public WeaponId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public int getDamageType() {
        return damageType;
    }
}
