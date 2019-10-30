package com.hz.yk.io.pratice.impl;

import com.hz.yk.io.pratice.Recevier;

import java.io.IOException;
import java.io.Writer;

/**
 * @author wuzheng.yk
 * @date 2019/10/23
 */
public class StringReceiver implements Recevier<String> {

    Writer writer;

    public StringReceiver(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void receiver(String msg) {
        try {
            writer.write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
