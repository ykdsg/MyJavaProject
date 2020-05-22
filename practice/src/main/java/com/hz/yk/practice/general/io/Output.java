package com.hz.yk.practice.general.io;

/**
 * 接受Sender，进行信息的输出，实际把输出的细节转包给了Receiver
 * 需要负责输出文件的初始化和关闭，以及对Receiver 的选择
 *
 * @author wuzheng.yk
 * @date 2020/3/10
 */
public interface Output<T, ReceiverThrowableType extends Throwable> {

    <SenderThrowableType extends Throwable> void receiveFrom(Sender<T, SenderThrowableType> sender)
            throws ReceiverThrowableType, SenderThrowableType;

}
