package com.hz.yk.yk.io.nio.reactor;

import java.io.IOException;

/**
 * @author wuzheng.yk
 *         Date: 14-8-10
 *         Time: ����3:14
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Reactor reactor = new Reactor(9999);
        new Thread(reactor).start();
    }
}

