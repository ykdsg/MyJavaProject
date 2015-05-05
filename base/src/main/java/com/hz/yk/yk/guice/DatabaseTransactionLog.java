package com.hz.yk.yk.guice;

import com.hz.yk.yk.guice.TransactionLog;

/**
 * @author wuzheng.yk
 *         Date: 15/5/1
 *         Time: 23:08
 */
public class DatabaseTransactionLog implements TransactionLog {
    @Override
    public void log() {
        System.out.println("data base log;");
    }
}
