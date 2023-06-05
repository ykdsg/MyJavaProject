package com.hz.yk.ddd.demo4.ecs.domain;

import com.hz.yk.ddd.demo4.ecs.entity.Player;
import com.hz.yk.ddd.demo4.ecs.entity.PlayerClass;
import com.hz.yk.ddd.demo4.ecs.entity.Weapon;
import com.hz.yk.ddd.demo4.ecs.entity.WeaponType;

/**
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public class FighterEquipmentPolicy implements EquipmentPolicy {

    @Override
    public boolean canApply(Player player, Weapon weapon) {
        return player.getPlayerClass() == PlayerClass.Fighter;
    }

    /**
     * Fighter能装备Sword和Dagger
     */
    @Override
    public boolean canEquip(Player player, Weapon weapon) {
        return weapon.getWeaponType() == WeaponType.Sword || weapon.getWeaponType() == WeaponType.Dagger;
    }

}
