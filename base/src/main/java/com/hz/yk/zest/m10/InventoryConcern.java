package com.hz.yk.zest.m10;

import org.qi4j.api.concern.ConcernOf;
import org.qi4j.api.injection.scope.Service;

import com.hz.yk.zest.m10.elsewhere.inventory.InventoryService;

/**
 * Extending the ConcernOf is a convenience mechanism, instead of an explicit @ConcernFor annotation on a private field,
 * which can be used in rare occasions when you are not able to extend. This base class defines the next field, which is
 * set up by the Zest™ runtime and points to the next fragment in the call stack.
 */
public class InventoryConcern extends ConcernOf<Order> implements Order {

    @Service
    private InventoryService inventory;

    @Override
    public void addLineItem(LineItem item) {
        String productCode = item.productCode().get();
        int quantity = item.quantity().get();
        inventory.remove(productCode, quantity);
        next.addLineItem(item);
    }

    @Override
    public void removeLineItem(LineItem item) {
        String productCode = item.productCode().get();
        int quantity = item.quantity().get();
        inventory.add(productCode, quantity);
        next.removeLineItem(item);
    }
}