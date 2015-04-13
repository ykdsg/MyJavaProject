package com.hz.yk.yk.guava.throwables;

import com.google.common.base.Throwables;
import java.util.List;

/**
 * @author wuzheng.yk
 *         Date: 14-7-18
 *         Time: ÉÏÎç11:15
 */
public class Main {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            Throwable rootThrowable = Throwables.getRootCause(e);
            System.out.println("rootThrowable: "+rootThrowable);
            List<Throwable> throwableList = Throwables.getCausalChain(e);
            System.out.println("list="+throwableList.toString());
            String stackTRace = Throwables.getStackTraceAsString(e);
            System.out.println("stackTrace="+stackTRace);
        }
    }

    static void method1(){
        method2();
    }

    static void method2(){
        method3();
    }

    static void method3() {
        Exception myException = new Exception("exc");
        throw new RuntimeException("run exc", myException);
    }
}
