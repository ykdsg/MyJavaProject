package com.hz.yk.ddd.demo4.oop;

/**
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public abstract class Weapon {

    int damage;
    int damageType; // 0 - physical, 1 - fire, 2 - ice etc.

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDamageType(int damageType) {
        this.damageType = damageType;
    }

    public int getDamage() {
        return damage;
    }

    public int getDamageType() {
        return damageType;
    }
}
