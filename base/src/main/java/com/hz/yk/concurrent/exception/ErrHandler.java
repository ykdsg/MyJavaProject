package com.hz.yk.concurrent.exception;

/**
 * �Զ����һ��UncaughtExceptionHandler
 * @author wuzheng.yk
 *         Date: 14-5-7
 *         Time: ����10:35
 */
public class ErrHandler implements Thread.UncaughtExceptionHandler {
    /**
     * ����������κ�����쳣�Ĵ���,�����¼��־�ȵ�
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("handler �����ˣ�This is:" + t.getName() + ",Message:"
                                   + e.getMessage());
        e.printStackTrace();
    }
}
