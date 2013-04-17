package com.hz.yk.io.generic;

/**
 * @author wuzheng.yk
 *         Date: 13-4-3
 *         Time: обнГ12:24
 */
public interface Output<T, ReceiverThrowableType extends Throwable> {
    <SenderThrowableType extends Throwable> void receiveFrom(Sender<T, SenderThrowableType> sender)
            throws ReceiverThrowableType, SenderThrowableType;
}
