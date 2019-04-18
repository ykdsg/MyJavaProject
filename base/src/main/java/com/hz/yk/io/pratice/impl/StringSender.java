package com.hz.yk.io.pratice.impl;

import com.hz.yk.io.pratice.Receiver;
import com.hz.yk.io.pratice.Sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author wuzheng.yk
 * @date 2019-03-14
 */
public class StringSender implements Sender<String> {

    final Reader reader;
    BufferedReader bufferReader;

    public StringSender(Reader reader) {
        this.reader = reader;
        bufferReader = new BufferedReader(reader);
    }

    @Override
    public void sendTo(Receiver<String> receiver) throws IOException {
        String readLine;

        while ((readLine = bufferReader.readLine()) != null) {
            receiver.receive(readLine);
        }
    }
}
