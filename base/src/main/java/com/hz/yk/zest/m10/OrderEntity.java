package com.hz.yk.zest.m10;

import org.qi4j.api.concern.Concerns;
import org.qi4j.api.entity.EntityComposite;
import org.qi4j.api.sideeffect.SideEffects;

/**
 * Zest™ works with Composites. The equivalent of an Object instance in OOP, is a Composite instance in Zest™.
 * Composites are constructed from Fragments. Fragments are Mixins, Concerns, Constraints and SideEffects. Only Mixins
 * carry Composite state. The others are shared between Composite instances. Created by wuzheng.yk on 16/12/1.
 */

/*
 * 当订单那确认的时候发一封邮件给sales@mycompany.com，这个是一个副作用，应该在Constraints，Concerns 和 Mixins 之后执行
 */
// 副作用(SideEffect) - 副作用也是Mixin的一个拦截器，但它是在方法执行完后执行的，因而它不能改变方法的入参和返回值。
@SideEffects(MailNotifySideEffect.class)
// Concerns are interceptors that are placed on the methods that they declare
// 关系(Concern) - 关系是Mixin的一个拦截器，一般用于事物处理，用户安全等，最好不要在关系中产生副作用。
@Concerns({ PurchaseLimitConcern.class, InventoryConcern.class })
public interface OrderEntity extends Order, Confirmable, HasSequenceNumber, HasCustomer, HasLineItems, EntityComposite {
}
