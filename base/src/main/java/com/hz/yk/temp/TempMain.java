package com.hz.yk.temp;

import org.junit.Test;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by wuzheng.yk on 2017/12/25.
 */
public class TempMain {

    private static final DecimalFormat TIME_OUT_TABLE_INDEX_FORMAT = new DecimalFormat("0000");

    /**
     * DecimalFormat 在多线程的情况下回出现异常
     */
    @Test
    public void testDecimalFormat() {
        for (int i = 0; i < 100000; i++) {
            Thread aThread = new Thread(new Runnable() {

                @Override
                public void run() {
                    String indexStr = "0001";
                    try {
                        int intValue = TIME_OUT_TABLE_INDEX_FORMAT.parse(indexStr).intValue();
                        if (intValue != 1) {
                            System.out.println(intValue);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });

            aThread.start();
        }
        for (int i = 0; i < 100000; i++) {
            Thread aThread = new Thread(new Runnable() {

                @Override
                public void run() {
                    String indexStr = "0002";
                    try {
                        int intValue = TIME_OUT_TABLE_INDEX_FORMAT.parse(indexStr).intValue();
                        if (intValue != 2) {
                            System.out.println(intValue);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        System.out.println("start");
        LockSupport.park();
    }
}
