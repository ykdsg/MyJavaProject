package com.hz.yk.zest.m10;

import org.qi4j.api.concern.Concerns;
import org.qi4j.api.entity.EntityComposite;
import org.qi4j.api.sideeffect.SideEffects;

/**
 * Created by wuzheng.yk on 16/12/1.
 */
// START SNIPPET: sideEffect
@SideEffects( MailNotifySideEffect.class )
// START SNIPPET: mainClass
@Concerns( { PurchaseLimitConcern.class, InventoryConcern.class } )
public interface OrderEntity extends Order, Confirmable,
        HasSequenceNumber, HasCustomer, HasLineItems,
        EntityComposite {
}
