package com.hz.yk.co.combinator;

import com.hz.yk.co.Logger;

/**
 * Created by wuzheng.yk on 16/12/1.
 */
public class NopLogger implements Logger {
    @Override
    public void print(int level, String msg) {

    }

    public void println(int level, String msg){}
    public void printException(int level, Throwable e){}
}
