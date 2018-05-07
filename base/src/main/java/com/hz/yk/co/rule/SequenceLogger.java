package com.hz.yk.co.rule;

import com.hz.yk.co.Logger;

/**
 * 顺序。把若干个logger对象顺序写一遍
 * Created by wuzheng.yk on 16/12/1.
 */
public class SequenceLogger implements Logger {
    private final Logger[] loggers;

    public SequenceLogger(Logger[] ls) {
        this.loggers = ls;
    }


    @Override
    public void print(int level, String msg) {
        for (Logger l : loggers) {
            l.print(level, msg);
        }
    }

    @Override
    public void println(int level, String msg) {
        for (Logger l : loggers) {
            l.println(level, msg);
        }
    }

    @Override
    public void printException(int level, Throwable e) {
        for (Logger l : loggers) {
            l.printException(level, e);
        }
    }


}
