package com.hz.yk.io.pratice.impl;

import com.hz.yk.io.pratice.Receiver;

import java.io.IOException;
import java.io.Writer;

/**
 * @author wuzheng.yk
 * @date 2019-03-20
 */
public class StringReceive implements Receiver<String> {

    private final Writer writer;

    public StringReceive(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void receive(String item) throws IOException {
        writer.write(item);
    }
}
