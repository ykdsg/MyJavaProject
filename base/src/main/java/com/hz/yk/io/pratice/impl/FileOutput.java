package com.hz.yk.io.pratice.impl;

import com.hz.yk.io.pratice.Output;
import com.hz.yk.io.pratice.Sender;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author wuzheng.yk
 * @date 2019-03-20
 */
public class FileOutput implements Output<String> {

    private File   destination;
    final   Writer writer;

    public FileOutput(File destination) throws IOException {
        this.destination = destination;
        writer = new FileWriter(destination);
    }

    @Override
    public void receiveFrom(Sender<String> sender) throws IOException {
        StringReceive receive = new StringReceive(writer);
        sender.sendTo(receive);
        writer.close();

    }
}
