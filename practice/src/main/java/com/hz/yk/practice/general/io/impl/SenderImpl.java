package com.hz.yk.practice.general.io.impl;

import com.hz.yk.practice.general.io.Receiver;
import com.hz.yk.practice.general.io.Sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author wuzheng.yk
 * @date 2020/3/10
 */
public class SenderImpl implements Sender<String, IOException> {

    private final BufferedReader bufferedReader;

    public SenderImpl(Reader reader) {
        bufferedReader = new BufferedReader(reader);
    }

    @Override
    public <ReceiverThrowableType extends Throwable> void sendTo(Receiver<String, ReceiverThrowableType> receiver)
            throws ReceiverThrowableType, IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            receiver.receive(line);
        }
    }
}
