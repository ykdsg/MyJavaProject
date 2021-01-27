package com.hz.yk.ddd.demo4.ecs.domain;

import com.hz.yk.ddd.demo4.ecs.entity.Player;
import com.hz.yk.ddd.demo4.ecs.entity.Weapon;

import java.util.ArrayList;
import java.util.List;

/**
 * 这样设计的最大好处是未来的规则增加只需要添加新的Policy类，而不需要去改变原有的类
 *
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public class EquipmentManager {

    private static final List<EquipmentPolicy> POLICIES = new ArrayList<>();

    static {
        POLICIES.add(new FighterEquipmentPolicy());
        //POLICIES.add(new MageEquipmentPolicy());
        //POLICIES.add(new DragoonEquipmentPolicy());
        //POLICIES.add(new DefaultEquipmentPolicy());
    }

    public boolean canEquip(Player player, Weapon weapon) {
        for (EquipmentPolicy policy : POLICIES) {
            if (!policy.canApply(player, weapon)) {
                continue;
            }
            return policy.canEquip(player, weapon);
        }
        return false;
    }

}
