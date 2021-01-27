package com.hz.yk.ddd.demo4.ecs.domain;

import com.hz.yk.ddd.demo4.ecs.entity.Monster;
import com.hz.yk.ddd.demo4.ecs.entity.Player;
import com.hz.yk.ddd.demo4.ecs.entity.Weapon;

/**
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public interface DamagePolicy {

    boolean canApply(Player player, Weapon weapon, Monster monster);

    int calculateDamage(Player player, Weapon weapon, Monster monster);
}
