package com.hz.yk.ddd.demo4.oop;

/**
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public abstract class Player {

    Weapon weapon;

    public void attack(Monster monster) {
        monster.receiveDamageBy(weapon, this);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}

