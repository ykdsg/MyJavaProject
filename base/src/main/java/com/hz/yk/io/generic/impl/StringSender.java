package com.hz.yk.io.generic.impl;

import com.hz.yk.io.generic.Receiver;
import com.hz.yk.io.generic.Sender;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

/**
 * @author wuzheng.yk
 *         Date: 13-4-5
 *         Time: 下午3:49
 */
public class StringSender implements Sender<String,IOException> {
    final Reader reader;
    BufferedReader bufferReader;


    public StringSender(Reader reader) throws FileNotFoundException {
        this.reader = reader;
        this.bufferReader = new BufferedReader(reader);
    }
    @Override
    public <ReceiverThrowableType extends Throwable> void sendTo(Receiver<String, ReceiverThrowableType> receiver)
            throws ReceiverThrowableType, IOException {
        String readLine;
        while((readLine = bufferReader.readLine()) != null) {
            receiver.receive(readLine + "\n");
        }
    }
}
