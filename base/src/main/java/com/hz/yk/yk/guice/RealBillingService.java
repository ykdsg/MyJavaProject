package com.hz.yk.yk.guice;

import com.google.inject.Inject;

/**
 * @author wuzheng.yk
 *         Date: 15/5/1
 *         Time: 22:46
 */
public class RealBillingService implements  BillingService{
    private final CreditCardProcessor processor;
    private final TransactionLog transactionLog;

    @Inject
    RealBillingService(CreditCardProcessor processor,
                       TransactionLog transactionLog) {
        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    @Override
    public void chargeOrder() {
        processor.process();
        transactionLog.log();
        System.out.println("real billing,,,");
    }
}
