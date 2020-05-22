package com.hz.yk.practice.general.io;

/**
 * 信息输入的口子，通过Sender进行信息的处理，然后给到output，
 * 需要负责输入信息的初始化和关闭，以及对Sender 的选择，可以通过new的方式，也可以通过注入的方式
 *
 * @author wuzheng.yk
 * @date 2020/3/10
 */
public interface Input<T, SenderThrowableType extends Throwable> {

    <ReceiverThrowableType extends Throwable> void transferTo(Output<T, ReceiverThrowableType> output)
            throws ReceiverThrowableType, SenderThrowableType;

}
