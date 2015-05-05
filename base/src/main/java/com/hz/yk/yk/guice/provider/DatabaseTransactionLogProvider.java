package com.hz.yk.yk.guice.provider;

import com.hz.yk.yk.guice.DatabaseTransactionLog;
import com.hz.yk.yk.guice.TransactionLog;
import javax.inject.Provider;

/**
 * @author wuzheng.yk
 *         Date: 15/5/3
 *         Time: 11:07
 */
public class DatabaseTransactionLogProvider implements Provider<TransactionLog> {
    @Override
    public TransactionLog get() {
        return new DatabaseTransactionLog();
    }

}
