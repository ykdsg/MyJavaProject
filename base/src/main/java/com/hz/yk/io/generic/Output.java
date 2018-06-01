package com.hz.yk.io.generic;

/**
 * @author wuzheng.yk
 *         Date: 13-4-3
 */
public interface Output<T, ReceiverThrowableType extends Throwable> {

    /**
     * 当receiveFrom方法被Input调用时（通过调用Input的transferTo方法触发），Output应该打开好了它所需要的资源，然后期望数据从Sender发送过来
     * @param sender
     * @param <SenderThrowableType>
     * @throws ReceiverThrowableType
     * @throws SenderThrowableType
     */
    <SenderThrowableType extends Throwable> void receiveFrom(Sender<T, SenderThrowableType> sender)
            throws ReceiverThrowableType, SenderThrowableType;
}
