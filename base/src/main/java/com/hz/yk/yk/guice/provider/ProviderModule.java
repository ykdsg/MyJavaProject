package com.hz.yk.yk.guice.provider;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.hz.yk.yk.guice.DatabaseTransactionLog;
import com.hz.yk.yk.guice.TransactionLog;

/**
 * 在configure方法中使用Provider绑定和直接写@Provides方法所实现的功能是没有差别的，不过使用Provider绑定会使代码更清晰。而且当提供对象的方法中也需要有其他类型的依赖注入时，使用Provider绑定会是更好的选择。
 * @author wuzheng.yk
 *         Date: 15/5/3
 *         Time: 11:09
 */
public class ProviderModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(TransactionLog.class).toProvider(DatabaseTransactionLogProvider.class);
    }

    @Provides
    TransactionLog provideTransactionLog() {
        DatabaseTransactionLog transactionLog = new DatabaseTransactionLog();
        return transactionLog;
    }
}
