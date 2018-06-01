package com.hz.yk.io.generic;

/**
 * @author wuzheng.yk
 *         Date: 13-4-3
 */
public interface Sender<T, SenderThrowableType extends Throwable> {

    /**
     * Output调用sendTo方法，传入一个Receiver，Sender使用这个Receiver来发送一个一个的数据。Sender在这个时候发起传输，把类型数据T传输到Receiver，一次一个
     * @param receiver
     * @param <ReceiverThrowableType>
     * @throws ReceiverThrowableType
     * @throws SenderThrowableType
     */
    <ReceiverThrowableType extends Throwable> void sendTo(Receiver<T, ReceiverThrowableType> receiver)
            throws ReceiverThrowableType, SenderThrowableType;
}
