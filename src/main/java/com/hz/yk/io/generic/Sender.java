package com.hz.yk.io.generic;

/**
 * @author wuzheng.yk
 *         Date: 13-4-3
 *         Time: обнГ12:29
 */
public interface Sender<T, SenderThrowableType extends Throwable> {
    <ReceiverThrowableType extends Throwable> void sendTo(Receiver<T, ReceiverThrowableType> receiver)
            throws ReceiverThrowableType, SenderThrowableType;
}