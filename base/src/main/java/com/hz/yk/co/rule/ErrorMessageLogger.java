package com.hz.yk.co.rule;

import com.hz.yk.co.Logger;

import java.io.PrintWriter;

/**
 * 对exception直接打印getMessage()
 * Created by wuzheng.yk on 16/12/2.
 */
public class ErrorMessageLogger implements Logger {
    private final PrintWriter out;
    private final Logger logger;


    public ErrorMessageLogger(PrintWriter out, Logger logger) {
        this.out = out;
        this.logger = logger;
    }

    @Override
    public void print(int level, String msg) {
        logger.print(level, msg);

    }

    public void println(int level, String msg) {
        logger.println(level, msg);
    }

    public void printException(Throwable e) {
        out.println(e.getMessage());
    }
}
