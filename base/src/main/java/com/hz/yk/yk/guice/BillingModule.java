package com.hz.yk.yk.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * @author wuzheng.yk
 *         Date: 15/5/1
 *         Time: 22:47
 */
public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        /*
      * This tells Guice that whenever it sees a dependency on a TransactionLog,
      * it should satisfy the dependency using a DatabaseTransactionLog.
      */
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);

     /*
      * Similarly, this binding tells Guice that when CreditCardProcessor is used in
      * a dependency, that should be satisfied with a PaypalCreditCardProcessor.
      */
        bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
    }

    @Provides
    TransactionLog provideTransactionLog() {
        DatabaseTransactionLog transactionLog = new DatabaseTransactionLog();
        return transactionLog;
    }
}
