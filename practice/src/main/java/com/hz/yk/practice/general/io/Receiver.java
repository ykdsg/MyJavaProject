package com.hz.yk.practice.general.io;

/**
 * 掌握在Output 手里，用来接受信息之后的处理
 *
 * @author wuzheng.yk
 * @date 2020/3/10
 */
public interface Receiver<T, ReceiverThrowableType extends Throwable> {

    void receive(T item) throws ReceiverThrowableType;
}
