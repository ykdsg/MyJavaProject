package com.hz.yk.co.combinator;

import com.hz.yk.co.Logger;

import java.io.PrintWriter;

/**
 * Created by wuzheng.yk on 16/12/1.
 */
public class WriterLogger implements Logger {

    private final PrintWriter writer;

    @Override
    public void print(int level, String msg) {
        writer.print(msg);
        writer.flush();
    }

    @Override
    public void println(int level, String msg) {
        writer.println(msg);
    }

    @Override
    public void printException(int level, Throwable e) {
        e.printStackTrace(writer);
    }

    public WriterLogger(PrintWriter writer){
        this.writer = writer;
    }
}
