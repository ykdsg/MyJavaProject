package com.hz.yk.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

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
    }

    private static void init() throws Exception {
        ServerImpl serverImpl = new ServerImpl();
        ServerMonitor serverMonitor = new ServerMonitor(serverImpl);
        String domainName = "objectName";

        // 下面这种方式不能在JConsole中使用
        //mBeanServer = MBeanServerFactory.createMBeanServer();
        mBeanServer = ManagementFactory.getPlatformMBeanServer();
        objectName1 = new ObjectName(domainName+":id=ServerMonitor1");
        mBeanServer.registerMBean(serverMonitor, objectName1);

        ServerDynamicMonitor serverMonitor2 = new ServerDynamicMonitor(serverImpl);
        objectName2 = new ObjectName(domainName+":id=ServerMonitor2");
        mBeanServer.registerMBean(serverMonitor2, objectName2);

        int rmiPort = 1099;
        //可以在某一特定端口创建名字服务，从而用户无需再手工启动rmiregistry，如果不加入这句代码，就会出现Connection Refused的异常
        Registry registry = LocateRegistry.createRegistry(rmiPort);

        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:" + rmiPort + "/" + domainName);
        JMXConnectorServer jmxConnector = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mBeanServer);
        jmxConnector.start();
    }

    private static void manage() throws Exception {
        Long upTime = (Long) mBeanServer.getAttribute(objectName1, "UpTime");
        System.out.println(upTime);

        Long upTime2 = (Long) mBeanServer.getAttribute(objectName2, "UpTime");
        System.out.println(upTime2);
    }
}
