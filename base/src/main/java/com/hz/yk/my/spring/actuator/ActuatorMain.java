package com.hz.yk.my.spring.actuator;

import org.apache.catalina.LifecycleException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.locks.LockSupport;

/**
 * 自定义动态装载的bean
 * Created by wuzheng.yk on 16/9/9.
 */
public class ActuatorMain {

    public static void main(String[] args) throws LifecycleException {
        ApplicationContext context = new ClassPathXmlApplicationContext("actuator_beans.xml");

        LockSupport.park();

        //Tomcat tomcat = new Tomcat();
        //tomcat.setHostname("localhost");
        //tomcat.setPort(8080);
        ////设置工作目录,其实没什么用,tomcat需要使用这个目录进行写一些东西
        //tomcat.setBaseDir("/Users/ykdsg/logs");
        //
        ////设置程序的目录信息
        //tomcat.getHost().setAppBase("/Users/ykdsg/logs");
        //// Add AprLifecycleListener
        //StandardServer server = (StandardServer) tomcat.getServer();
        //AprLifecycleListener listener = new AprLifecycleListener();
        //server.addLifecycleListener(listener);
        ////注册关闭端口以进行关闭
        //tomcat.getServer().setPort(8099);
        ////加载上下文
        //StandardContext standardContext = new StandardContext();
        //standardContext.setPath("/");//contextPath
        //standardContext.setDocBase("tomcat");//文件目录位置
        //standardContext.addLifecycleListener(new Tomcat.DefaultWebXmlListener());
        ////保证已经配置好了。
        //standardContext.addLifecycleListener(new Tomcat.FixContextListener());
        //standardContext.setSessionCookieName("t-session");
        //tomcat.getHost().addChild(standardContext);
        //tomcat.start();
        //tomcat.getServer().await();

    }
}
