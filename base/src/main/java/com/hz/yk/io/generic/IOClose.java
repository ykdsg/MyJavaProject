package com.hz.yk.io.generic;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by wuzheng.yk on 15/8/20.
 */
public class IOClose {

    public static void main(String[] args) throws IOException, InterruptedException {
        ByteArrayInputStream stream = new ByteArrayInputStream("testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest".getBytes());

        for (int i = 0; i < 10000; i++) {
            Thread.sleep(50);
            stream = new ByteArrayInputStream("testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest".getBytes());
            int read = stream.read();
            System.out.println(read+":"+i);
        }

        stream.close();
        Thread.sleep(10000000);
    }
}
