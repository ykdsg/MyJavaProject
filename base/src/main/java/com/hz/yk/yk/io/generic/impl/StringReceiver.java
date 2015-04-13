package com.hz.yk.yk.io.generic.impl;

import com.hz.yk.yk.io.generic.Receiver;
import java.io.IOException;
import java.io.Writer;

/**
 * @author wuzheng.yk
 *         Date: 13-4-5
 *         Time: 下午3:55
 */
public class StringReceiver implements Receiver<String, IOException> {
    final Writer writer;

    public StringReceiver(Writer writer) throws IOException {
        this.writer = writer;
    }

    @Override
    public void receive(String item) throws IOException {
        writer.write(item);
    }

    public void finished() throws IOException {
    }
}
