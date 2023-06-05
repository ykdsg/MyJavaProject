package com.hz.yk.ddd.demo4.oop;

/**
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public class Dragon extends Monster {

    public Dragon(String dragon, long health) {
        this.setHealth(health);
    }

    @Override
    public void receiveDamageBy(Weapon weapon, Player player) {
        if (player instanceof Dragoon) {
            this.setHealth(this.getHealth() - weapon.getDamage() * 2); // 龙骑伤害规则
        }
        // else no damage, 龙免疫力规则
    }

}
