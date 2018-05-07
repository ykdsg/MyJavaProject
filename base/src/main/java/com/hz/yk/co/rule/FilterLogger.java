package com.hz.yk.co.rule;

import com.hz.yk.co.LogLevelConstant;
import com.hz.yk.co.Logger;

/**
 * 当消息的重要程度等于某一个级别的时候，写logger1，否则写logger2。 Created by wuzheng.yk on 16/12/2.
 */
public class FilterLogger implements Logger {

    private final Logger logger1;
    private final Logger logger2;
    private final int    lvl;

    public FilterLogger(int lvl, Logger logger1, Logger logger2){
        this.logger1 = logger1;
        this.logger2 = logger2;
        this.lvl = lvl;
    }

    @Override
    public void print(int level, String msg) {
        if (level == lvl) logger1.print(level, msg);
        else logger2.print(level, msg);
    }

    @Override
    public void println(int level, String msg) {
        if (level == lvl) {
            logger1.println(level, msg);
        }
        else {
            logger2.println(level, msg);
        }
    }

    @Override
    public void printException(int level, Throwable e) {
        if (lvl == LogLevelConstant.ERROR) {
            logger1.printException(level, e);
        }
        else {
            logger2.printException(level, e);
        }
    }
}
