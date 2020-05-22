package com.hz.yk.practice.general.io.impl;

import com.hz.yk.practice.general.io.Input;
import com.hz.yk.practice.general.io.Output;
import com.hz.yk.practice.general.io.Sender;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author wuzheng.yk
 * @date 2020/3/10
 */
public class InputImpl implements Input<String, IOException> {

    private final Reader reader;

    public InputImpl(File file) throws FileNotFoundException {
        this.reader = new FileReader(file);
    }

    @Override
    public <ReceiverThrowableType extends Throwable> void transferTo(Output<String, ReceiverThrowableType> output)
            throws ReceiverThrowableType, IOException {

        Sender<String, IOException> sender = new SenderImpl(reader);
        output.receiveFrom(sender);
        reader.close();
    }
}
