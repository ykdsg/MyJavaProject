package com.hz.yk.io.pratice.impl;

import com.hz.yk.io.pratice.Input;
import com.hz.yk.io.pratice.Output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author wuzheng.yk
 * @date 2019-03-14
 */
public class FileInput implements Input {

    final File   source;
    final Reader reader;

    public FileInput(File source) throws FileNotFoundException {
        this.source = source;
        reader = new FileReader(source);
    }

    @Override
    public void transferTo(Output output) throws IOException {
        final StringSender sender = new StringSender(reader);
        output.receiveFrom(sender);

        try {
            reader.close();
        } catch (Exception e) {
            // ignore close exception :)
        }
    }
}
