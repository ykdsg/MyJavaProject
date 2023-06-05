package com.hz.yk.ddd.demo4.ecs.domain;

import com.hz.yk.ddd.demo4.ecs.entity.Player;
import com.hz.yk.ddd.demo4.ecs.entity.Weapon;

/**
 * 使用策略模式
 *
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public class EquipmentServiceImpl implements EquipmentService {

    private EquipmentManager equipmentManager;

    @Override
    public boolean canEquip(Player player, Weapon weapon) {
        return equipmentManager.canEquip(player, weapon);
    }

}
