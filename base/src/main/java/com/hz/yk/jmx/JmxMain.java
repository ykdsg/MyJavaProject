package com.hz.yk.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * Created by wuzheng.yk on 2017/12/1.
 */
public class JmxMain {

    private static ObjectName  objectName1;
    private static ObjectName  objectName2;
    private static MBeanServer mBeanServer;

    public static void main(String[] args) throws Exception {
        init();
        manage();
        Thread.sleep(500000);
    }

    private static void init() throws Exception {
        ServerImpl serverImpl = new ServerImpl();
        ServerMonitor serverMonitor = new ServerMonitor(serverImpl);
        // 下面这种方式不能在JConsole中使用
        //mBeanServer = MBeanServerFactory.createMBeanServer();
        mBeanServer = ManagementFactory.getPlatformMBeanServer();
        objectName1 = new ObjectName("objectName:id=ServerMonitor1");
        mBeanServer.registerMBean(serverMonitor, objectName1);

        ServerDynamicMonitor serverMonitor2 = new ServerDynamicMonitor(serverImpl);
        objectName2 = new ObjectName("objectName:id=ServerMonitor2");
        mBeanServer.registerMBean(serverMonitor2, objectName2);
        Thread.sleep(500000);

    }

    private static void manage() throws Exception {
        Long upTime = (Long) mBeanServer.getAttribute(objectName1, "UpTime");
        System.out.println(upTime);

        Long upTime2 = (Long) mBeanServer.getAttribute(objectName2, "UpTime");
        System.out.println(upTime2);
    }
}
