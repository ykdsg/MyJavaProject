package com.hz.yk.io.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by wuzheng.yk on 2017/6/20.
 */
public class ByteOrderTest {

    public static void main(String[] args) {
        System.out.println(ByteOrder.nativeOrder());
        ByteBuffer bf = ByteBuffer.allocate(10);
        System.out.println("bf order=" + bf.order());
    }
}
