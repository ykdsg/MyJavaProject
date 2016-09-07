package com.hz.yk.io.nio.direct;

/**
 * Created by wuzheng.yk on 16/4/9.
 */
public class TimeClient {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int port = 8080;
        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001")
                .start();
    }
}
