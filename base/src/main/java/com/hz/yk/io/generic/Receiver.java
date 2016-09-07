package com.hz.yk.io.generic;

/**
 * @author wuzheng.yk
 *         Date: 13-4-3
 *         Time: ����7:51
 */
public interface Receiver<T, ReceiverThrowableType extends Throwable> {
    void receive(T item) throws ReceiverThrowableType;
}
