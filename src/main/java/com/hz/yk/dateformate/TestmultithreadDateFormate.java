package com.hz.yk.dateformate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: wb-yangke
 * Date: 11-7-15
 * Time: ионГ10:26
 * To change this template use File | Settings | File Templates.
 */
public class TestmultithreadDateFormate {
    final static SimpleDateFormat DATE_FORMAT_TO_DAY = new SimpleDateFormat("yymmdd hh:mm:ss");
    final static int count = 10000000;

    public static void main(String[] args) {
        for (int i = 0; i < count; i++) {
            DateThread thread = new TestmultithreadDateFormate().new DateThread();
            thread.start();
        }
    }

     class DateThread extends Thread {
        @Override
        public void run() {
            String date=DATE_FORMAT_TO_DAY.format(new Date());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//            }
            System.out.println(date);
        }
    }
}
