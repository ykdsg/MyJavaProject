package com.hz.yk.yk.io.generic;

/**
 * @author wuzheng.yk
 *         Date: 13-4-3
 */
public interface Input<T, SenderThrowableType extends Throwable> {
    <ReceiverThrowableType extends Throwable>
    void transferTo(Output<T, ReceiverThrowableType> output)
            throws SenderThrowableType, ReceiverThrowableType;
}
