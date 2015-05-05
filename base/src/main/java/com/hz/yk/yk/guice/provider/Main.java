package com.hz.yk.yk.guice.provider;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.hz.yk.yk.guice.BillingModule;
import com.hz.yk.yk.guice.TransactionLog;

/**
 * @author wuzheng.yk
 *         Date: 15/5/3
 *         Time: 11:16
 */
public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ProviderModule());
        TransactionLog transactionLog = injector.getInstance(TransactionLog.class);
        transactionLog.log();
    }
}
