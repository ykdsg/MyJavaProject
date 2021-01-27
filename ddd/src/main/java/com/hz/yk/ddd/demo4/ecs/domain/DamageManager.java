package com.hz.yk.ddd.demo4.ecs.domain;

import com.hz.yk.ddd.demo4.ecs.entity.Monster;
import com.hz.yk.ddd.demo4.ecs.entity.Player;
import com.hz.yk.ddd.demo4.ecs.entity.Weapon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public class DamageManager {

    private static final List<DamagePolicy> POLICIES = new ArrayList<>();

    static {
        POLICIES.add(new DragoonPolicy());
        //POLICIES.add(new DragonImmunityPolicy());
        //POLICIES.add(new OrcResistancePolicy());
        //POLICIES.add(new ElfResistancePolicy());
        //POLICIES.add(new PhysicalDamagePolicy());
        //POLICIES.add(new DefaultDamagePolicy());
    }

    public int calculateDamage(Player player, Weapon weapon, Monster monster) {
        for (DamagePolicy policy : POLICIES) {
            if (!policy.canApply(player, weapon, monster)) {
                continue;
            }
            return policy.calculateDamage(player, weapon, monster);
        }
        return 0;
    }

}
