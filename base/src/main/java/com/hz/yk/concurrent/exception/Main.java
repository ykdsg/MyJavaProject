package com.hz.yk.concurrent.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wuzheng.yk
 *         Date: 14-5-7
 *         Time: ����10:34
 */
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ThreadA a  = new ThreadA();
        ErrHandler handle = new ErrHandler();
        //��������ȫ�ֵ� UncaughtExceptionHandler
        Thread.setDefaultUncaughtExceptionHandler(handle);
//        a.setUncaughtExceptionHandler(handle);// ���붨���ErrHandler

        try {  //���̵߳�tryû����
            a.start();
        } catch (Exception e) {
            log.error("[Main-main]error", e);
            System.out.println("��catch���");
        }
        String s = null;
        System.out.println(s.chars());


    }
}
