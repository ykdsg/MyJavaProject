package com.hz.yk.practice.general.io.impl;

import com.hz.yk.practice.general.io.Receiver;

import java.io.IOException;
import java.io.Writer;

/**
 * @author wuzheng.yk
 * @date 2020/3/10
 */
public class ReceiverImpl implements Receiver<String, IOException> {

    Writer writer;

    public ReceiverImpl(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void receive(String item) throws IOException {
        //这里打印一下方面控制台看到
        System.out.println(item);
        writer.write(item);
    }
}
