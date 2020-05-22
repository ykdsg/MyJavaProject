package com.hz.yk.practice.general.io.impl;

import com.hz.yk.practice.general.io.Output;
import com.hz.yk.practice.general.io.Receiver;
import com.hz.yk.practice.general.io.Sender;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author wuzheng.yk
 * @date 2020/3/10
 */
public class OutputImpl implements Output<String, IOException> {

    private final Writer writer;

    public OutputImpl(File file) throws IOException {
        writer = new FileWriter(file);
    }

    @Override
    public <SenderThrowableType extends Throwable> void receiveFrom(Sender<String, SenderThrowableType> sender)
            throws IOException, SenderThrowableType {
        Receiver<String, IOException> receiver = new ReceiverImpl(writer);
        sender.sendTo(receiver);
        writer.close();
    }
}
