package com.hz.yk.co.factory.impl;

import com.hz.yk.co.factory.SourceLocationFormat;

/**
 * Created by wuzheng.yk on 2018/5/2.
 */
public class SourceLocationFormatImpl implements SourceLocationFormat {

    @Override
    public String format(StackTraceElement frame) {
        return frame.getClassName() + "-" + frame.getMethodName() + ":" + frame.getLineNumber();
    }
}
