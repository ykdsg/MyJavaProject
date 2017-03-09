package com.hz.yk.jstorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * Created by wuzheng.yk on 17/3/6.
 */
public class BootStrap {
    public static void main(String[] args) {
        try {
            //在nimbus机器上，从命令行寻找响应topology配置,spout,bolt,worker配置 暂不支持同时启动多个topology
            String configPath = args[0];
            Properties config = ConfigUtils.init(configPath, false);
            ((ILogTopology) BootStrap.SpringContext.instance.getBean("testtopology")).start(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //static class Log4JInitBean {
    //    public static void init() {
    //        File file = new File("/home/work/jstorm_cluster/jstorm-0.9.6.3/biglog_conf/log4j.xml");
    //        if (file.exists()) {
    //            System.out.println("log4j init from /home/work/jstorm_cluster/jstorm-0.9.6.3/biglog_conf/log4j.xml");
    //            DOMConfigurator.configure("/home/work/jstorm_cluster/jstorm-0.9.6.3/biglog_conf/log4j.xml");
    //        } else {
    //            System.out.println("log4j init from default");
    //        }
    //    }
    //}

    static class SpringContext {
        //static {
        //    Log4JInitBean.init();
        //}

        public static ApplicationContext instance = new ClassPathXmlApplicationContext(
                "/config/demo-beans-context.xml");
    }
}
