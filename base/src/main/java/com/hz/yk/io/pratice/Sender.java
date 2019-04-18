package com.hz.yk.io.pratice;

import java.io.IOException;

/**
 * @author wuzheng.yk
 * @date 2019-03-14
 */
public interface Sender<T> {

    void sendTo(Receiver<T> receiver) throws IOException;
}
