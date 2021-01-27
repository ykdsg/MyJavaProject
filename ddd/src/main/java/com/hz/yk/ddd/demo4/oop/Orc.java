package com.hz.yk.ddd.demo4.oop;

/**
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public class Orc extends Monster {

    @Override
    public void receiveDamageBy(Weapon weapon, Player player) {
        if (weapon.getDamageType() == 0) {
            this.setHealth(this.getHealth() - weapon.getDamage() / 2); // Orc的物理防御规则
        } else {
            super.receiveDamageBy(weapon, player);
        }
    }

}
