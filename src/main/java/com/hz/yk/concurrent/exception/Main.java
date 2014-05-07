package com.hz.yk.concurrent.exception;

/**
 * @author wuzheng.yk
 *         Date: 14-5-7
 *         Time: 上午10:34
 */
public class Main {

    public static void main(String[] args) {
        ThreadA a  = new ThreadA();
        ErrHandler handle = new ErrHandler();
        //这里设置全局的 UncaughtExceptionHandler
        Thread.setDefaultUncaughtExceptionHandler(handle);
//        a.setUncaughtExceptionHandler(handle);// 加入定义的ErrHandler
        a.start();

    }
}
