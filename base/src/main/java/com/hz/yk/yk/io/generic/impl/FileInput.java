package com.hz.yk.yk.io.generic.impl;

import com.hz.yk.yk.io.generic.Input;
import com.hz.yk.yk.io.generic.Output;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author wuzheng.yk
 *         Date: 13-4-5
 *         Time: 下午3:37
 */
public  class FileInput implements Input<String,IOException> {
    final File source;
    final Reader reader;

    public FileInput(File source) throws IOException {
        this.source = source;
        reader = new FileReader(source);
    }

    public <ReceiverThrowableType extends Throwable> void transferTo(Output<String, ReceiverThrowableType> output)
            throws IOException, ReceiverThrowableType {
        final StringSender sender = new StringSender(reader);
        output.receiveFrom(sender);

        try {
            reader.close();
        } catch (Exception e) {
            // ignore close exception :)
        }
    }
}
