package com.hz.yk.ddd.demo4.oop;

/**
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public abstract class Monster {

    Long health;

    public void receiveDamageBy(Weapon weapon, Player player) {
        this.health -= weapon.getDamage(); // 基础规则
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }
}
