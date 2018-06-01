package com.hz.yk.io.generic;

/**
 * Input，如Iterables，可以被多次使用，用于初始化一处到另一处的传输。因为我泛化传输的数据类型为T，所以可以是任何类型（byte[]、String、EntityState、MyDomainObject
 * ）。为了让发送者和接收者可以抛出各自的异常，接口上把各自己的异常声明成了类型参数。比如：在出错的时，Input抛的可以是SQLException，Output抛的是IOException
 * 。异常是强类型的，并且在出错时发送和接收双方都必须知道的，这使的双方做合适的恢复操作，关闭他们打开了的资源。
 *
 * @author wuzheng.yk
 * Date: 13-4-3
 */
public interface Input<T, SenderThrowableType extends Throwable> {

    /**
     * 从一处到另一处的传输
     * @param output
     * @param <ReceiverThrowableType>
     * @throws SenderThrowableType
     * @throws ReceiverThrowableType
     */
    <ReceiverThrowableType extends Throwable> void transferTo(Output<T, ReceiverThrowableType> output)
            throws SenderThrowableType, ReceiverThrowableType;
}
