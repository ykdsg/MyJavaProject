package com.hz.yk.my.spring.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by wuzheng.yk on 17/4/28.
 */
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asynTask = context.getBean(AsyncTaskService.class);

        for (int i = 0; i < 10; i++) {
            asynTask.executeAsyncTask1(i);
        }

        context.close();
    }
}
