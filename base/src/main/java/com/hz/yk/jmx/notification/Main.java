package com.hz.yk.jmx.notification;

import com.hz.yk.jmx.hello.Hello;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * http://blog.csdn.net/u013256816/article/details/52808328
 * Created by wuzheng.yk on 2017/12/8.
 */
public class Main {
    public static void main(String[] args)
            throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException,
                   MBeanRegistrationException, IOException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        ObjectName helloName = new ObjectName("MyMBean:name=HelloWorld");
        Hello hello = new Hello();
        mbs.registerMBean(hello,helloName);


        XiaoSi xs = new XiaoSi();
        mbs.registerMBean(xs,new ObjectName("MyMBean:name=xiaosi"));
        xs.addNotificationListener(new HelloListener(),null,hello);

        int rmiPort = 1099;
        Registry registry = LocateRegistry.createRegistry(rmiPort);

        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:" + rmiPort + "/MyMBean" );
        JMXConnectorServer jmxConnector = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
        jmxConnector.start();
    }
}
