package com.hz.yk.io.generic;

/**
 * @author wuzheng.yk
 *         Date: 13-4-3
 */
public interface Receiver<T, ReceiverThrowableType extends Throwable> {

    /**
     * 当Receiver从Sender收到数据时，即可以马上写到底层资源中，也可以分批写入。Receiver知道传输什么时候结束（sendTo方法返回了），所以正确写入剩下的分批数据、关闭持有的资源。
     * @param item
     * @throws ReceiverThrowableType
     */
    void receive(T item) throws ReceiverThrowableType;
}
