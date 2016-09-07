package com.hz.yk.concurrent.exception;

/**
 * @author wuzheng.yk
 *         Date: 14-5-7
 *         Time: ����10:35
 */
public class ThreadA extends Thread {
    public ThreadA() {
         super();
        setName("yktest");
    }

    public void run() {
        double i = 12 / 0;// �׳��쳣�ĵط�
    }
}
