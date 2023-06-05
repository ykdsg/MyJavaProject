package com.hz.yk.ddd.demo4.ecs.domain;

import com.hz.yk.ddd.demo4.ecs.entity.Monster;
import com.hz.yk.ddd.demo4.ecs.entity.Player;

/**
 * 在上文中曾经有提起过，到底应该是Player.attack(Monster)还是Monster.receiveDamage(Weapon, Player)？在DDD里，因为这个行为可能会影响到Player、Monster和Weapon，所以属于跨实体的业务逻辑。在这种情况下需要通过一个第三方的领域服务（Domain Service）来完成。
 * 特别需要注意的是这里的CombatService领域服务和3.2的EquipmentService领域服务，虽然都是领域服务，但实质上有很大的差异。上文的EquipmentService更多的是提供只读策略，且只会影响单个对象，所以可以在Player.equip方法上通过参数注入。但是CombatService有可能会影响多个对象，所以不能直接通过参数注入的方式调用。
 *
 * @author wuzheng.yk
 * @date 2021/1/26
 */
public interface CombatService {

    void performAttack(Player player, Monster monster);
}
