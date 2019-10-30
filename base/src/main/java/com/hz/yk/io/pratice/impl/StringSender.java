package com.hz.yk.io.pratice.impl;

import com.hz.yk.io.pratice.Recevier;
import com.hz.yk.io.pratice.Sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author wuzheng.yk
 * @date 2019/10/23
 */
public class StringSender implements Sender<String> {

    private BufferedReader bufferedReader;

    public StringSender(Reader reader) {
        bufferedReader = new BufferedReader(reader);
    }

    @Override
    public void sendTo(Recevier<String> receiver) {
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                receiver.receiver(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
