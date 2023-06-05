package com.hz.yk.ddd.demo4.ecs.domain;

import com.hz.yk.ddd.demo4.ecs.entity.Monster;
import com.hz.yk.ddd.demo4.ecs.entity.MonsterClass;
import com.hz.yk.ddd.demo4.ecs.entity.Player;
import com.hz.yk.ddd.demo4.ecs.entity.PlayerClass;
import com.hz.yk.ddd.demo4.ecs.entity.Weapon;

/**
 * 策略案例
 *
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public class DragoonPolicy implements DamagePolicy {

    @Override
    public int calculateDamage(Player player, Weapon weapon, Monster monster) {
        return weapon.getDamage() * 2;
    }

    @Override
    public boolean canApply(Player player, Weapon weapon, Monster monster) {
        return player.getPlayerClass() == PlayerClass.Dragoon && monster.getMonsterClass() == MonsterClass.Dragon;
    }

}
