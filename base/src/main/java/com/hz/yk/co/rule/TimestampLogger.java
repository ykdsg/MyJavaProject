package com.hz.yk.co.rule;

import com.hz.yk.co.Logger;

import java.util.Date;

import static com.hz.yk.co.LogLevelConstant.ERROR;

/**
 * Created by wuzheng.yk on 16/12/2.
 */
public class TimestampLogger implements Logger {

    private final Logger logger;

    public TimestampLogger(Logger logger){
        this.logger = logger;
    }

    @Override
    public void print(int level, String msg) {
        logger.print(level, new Date().toString() + ": " + msg);

    }

    @Override
    public void println(int level, String msg) {
        logger.println(level, new Date().toString() + ": " + msg);
    }

    @Override
    public void printException(int level, Throwable e) {
        logger.println(ERROR, new Date().toString() + ": ");
        logger.printException(level, e);
    }
}
