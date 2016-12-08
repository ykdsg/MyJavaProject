package com.hz.yk.co;

/**
 * Created by wuzheng.yk on 16/12/1.
 */
public interface Logger {

    void print(int level, String msg);
    void println(int level, String msg);
    void printException(Throwable e);


}
