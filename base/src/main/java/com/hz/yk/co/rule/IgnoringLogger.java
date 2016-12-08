package com.hz.yk.co.rule;

import com.hz.yk.co.Logger;

import static com.hz.yk.co.LogLevelConstant.ERROR;

/**
 * 当消息的重要程度大于等于某一个值的时候，我们写入logger1，否则写入logger2。
 * Created by wuzheng.yk on 16/12/2.
 */
public class IgnoringLogger implements Logger{
    private final int lvl;
    private final Logger logger1;
    private final Logger logger2;

    public IgnoringLogger(int lvl,Logger logger1, Logger logger2) {
        this.logger1 = logger1;
        this.logger2 = logger2;
        this.lvl = lvl;
    }

    @Override
    public void print(int level, String msg) {
        if(level>=lvl)logger1.print(level, msg);
        else logger2.print(level, msg);
    }

    public void println(int level, String msg){
        if(level>=lvl)logger1.println(level, msg);
        else logger2.println(level, msg);
    }
    public void printException(Throwable e){
        if(lvl<=ERROR) logger1.printException(e);
        else logger2.printException(e);
    }
}
