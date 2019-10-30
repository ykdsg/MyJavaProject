package com.hz.yk.io.pratice.impl;

import com.hz.yk.io.pratice.Output;
import com.hz.yk.io.pratice.Recevier;
import com.hz.yk.io.pratice.Sender;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author wuzheng.yk
 * @date 2019/10/23
 */
public class FileOutput implements Output<String> {

    private File outFile;
    private Writer writer;

    public FileOutput(File outFile) {
        try {
            writer = new FileWriter(outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void receiveFrom(Sender<String> sender) {
        Recevier<String> recevier = new StringReceiver(writer);
        sender.sendTo(recevier);

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
