package com.hz.yk.concurrent.exception;

/**
 * @author wuzheng.yk
 *         Date: 14-5-7
 *         Time: ����10:34
 */
public class Main {

    public static void main(String[] args) {
        ThreadA a  = new ThreadA();
        ErrHandler handle = new ErrHandler();
        //��������ȫ�ֵ� UncaughtExceptionHandler
        Thread.setDefaultUncaughtExceptionHandler(handle);
//        a.setUncaughtExceptionHandler(handle);// ���붨���ErrHandler

        try {  //���̵߳�tryû����
            a.start();
        } catch (Exception e) {
            System.out.println("��catch���");
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}
