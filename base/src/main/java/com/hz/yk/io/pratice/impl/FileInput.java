package com.hz.yk.io.pratice.impl;

import com.hz.yk.io.pratice.Input;
import com.hz.yk.io.pratice.Output;
import com.hz.yk.io.pratice.Sender;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author wuzheng.yk
 * @date 2019/10/23
 */
public class FileInput implements Input<String> {

    private Reader reader;

    public FileInput(File file) throws FileNotFoundException {
        reader = new FileReader(file);
    }

    @Override
    public void transferTo(Output<String> output) {
        Sender<String> sender = new StringSender(reader);
        output.receiveFrom(sender);

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
