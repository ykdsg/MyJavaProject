package com.hz.yk.jmx;

/**
 * Created by wuzheng.yk on 2017/12/1.
 */
public class Server {

    private long startTime;

    public Server() {
    }

    public int start() {
        startTime = System.currentTimeMillis();
        return 0;
    }

    public long getUpTime() {
        return System.currentTimeMillis() - startTime;
    }
}
