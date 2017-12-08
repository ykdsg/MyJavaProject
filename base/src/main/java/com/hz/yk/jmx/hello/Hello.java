package com.hz.yk.jmx.hello;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 * MBean 实现
 * Created by wuzheng.yk on 2017/12/7.
 */
public class Hello extends NotificationBroadcasterSupport implements HelloMBean {

    private String name;

    private long sequenceNumber = 1;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
        /*
         * To send a notification,you need to construct an instance of class
         * Notification or a Subclass(such as AttributeChangedNotification),and
         * pass the instance to NotificationBroadcastSupport.sendNotification.
         *
         */
        //用Notification类构造通知实例，发送通知实例由NotificationBroadcaterSupport.sendNotification方法;
        Notification n = new AttributeChangeNotification(this,
                                                         sequenceNumber++, System.currentTimeMillis(),
                                                         "name changed", "name", "String", name,
                                                         this.name);

        sendNotification(n);
    }

    @Override
    public void printHello() {
        System.out.println("Hello world, " + name);
    }

    @Override
    public void printHello(String whoName) {
        System.out.println("Hello, " + whoName);
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE };
        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name,
                                                               description);
        return new MBeanNotificationInfo[] { info };
    }
}
