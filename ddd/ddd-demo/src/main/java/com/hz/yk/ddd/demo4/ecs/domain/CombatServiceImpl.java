package com.hz.yk.ddd.demo4.ecs.domain;

import com.hz.yk.ddd.demo4.ecs.entity.Monster;
import com.hz.yk.ddd.demo4.ecs.entity.Player;
import com.hz.yk.ddd.demo4.ecs.entity.Weapon;

/**
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public class CombatServiceImpl implements CombatService {

    private WeaponRepository weaponRepository;
    private DamageManager damageManager;

    @Override
    public void performAttack(Player player, Monster monster) {
        Weapon weapon = weaponRepository.find(player.getWeaponId());
        int damage = damageManager.calculateDamage(player, weapon, monster);
        if (damage > 0) {
            monster.takeDamage(damage); // （Note 1）在领域服务里变更Monster
        }
        // 省略掉Player和Weapon可能受到的影响
    }

}
