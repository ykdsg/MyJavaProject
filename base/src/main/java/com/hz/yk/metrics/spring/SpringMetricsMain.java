package com.hz.yk.metrics.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by wuzheng.yk on 2017/12/21.
 */
public class SpringMetricsMain {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguringClass.class);
        TestBean testBean = applicationContext.getBean(TestBean.class);
        for (int i = 0; i < 100; i++) {
            testBean.timedMethod();
            Thread.sleep(500);

        }

        LockSupport.park();

    }
}
