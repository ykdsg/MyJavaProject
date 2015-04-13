package com.hz.yk.yk.concurrent.exception;

/**
 * 自定义的一个UncaughtExceptionHandler
 * @author wuzheng.yk
 *         Date: 14-5-7
 *         Time: 上午10:35
 */
public class ErrHandler implements Thread.UncaughtExceptionHandler {
    /**
     * 这里可以做任何针对异常的处理,比如记录日志等等
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("handler 处理到了，This is:" + t.getName() + ",Message:"
                                   + e.getMessage());
        e.printStackTrace();
    }
}
