package com.hz.yk.yk.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author wuzheng.yk
 *         Date: 15/5/1
 *         Time: 22:49
 */
public class Main {
    public static void main(String[] args) {
     /*
    * Guice.createInjector() takes your Modules, and returns a new Injector
    * instance. Most applications will call this method exactly once, in their
    * main() method.
    */
        Injector injector = Guice.createInjector(new BillingModule());

   /*
    * Now that we've got the injector, we can build objects.
    */
        BillingService billingService = injector.getInstance(RealBillingService.class);
        billingService.chargeOrder();
    }
}
