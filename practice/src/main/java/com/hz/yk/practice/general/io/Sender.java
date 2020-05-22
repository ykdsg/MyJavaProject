package com.hz.yk.practice.general.io;

/**
 * 负责对信息输入源进行处理之后进行发送
 *
 * @author wuzheng.yk
 * @date 2020/3/10
 */
public interface Sender<T, SenderThrowableType extends Throwable> {

    <ReceiverThrowableType extends Throwable> void sendTo(Receiver<T, ReceiverThrowableType> receiver)
            throws ReceiverThrowableType, SenderThrowableType;
}
