package com.hz.yk.jmx.notification;

import com.hz.yk.jmx.hello.Hello;

import javax.management.Notification;
import javax.management.NotificationListener;

/**
 * Created by wuzheng.yk on 2017/12/8.
 */
public class HelloListener implements NotificationListener {

    @Override
    public void handleNotification(Notification notification, Object handback) {
        System.out.println("----------HelloListener-Begin------------");
        System.out.println("\ttype = " + notification.getType());
        System.out.println("\tsource = " + notification.getSource());
        System.out.println("\tseq = " + notification.getSequenceNumber());
        System.out.println("\tsend time = " + notification.getTimeStamp());
        System.out.println("\tmessage=" + notification.getMessage());
        System.out.println("----------HelloListener-End------------");

        if (handback != null) {
            if (handback instanceof Hello) {
                Hello hello = (Hello) handback;
                hello.printHello("name=" + hello.getName() + ",message=" + notification.getMessage());
            }
        }
    }

}
