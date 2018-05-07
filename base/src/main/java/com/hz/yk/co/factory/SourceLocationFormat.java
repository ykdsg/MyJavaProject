package com.hz.yk.co.factory;

/**
 * Created by wuzheng.yk on 2018/5/2.
 */
public interface SourceLocationFormat {
    String format(StackTraceElement frame);
}
