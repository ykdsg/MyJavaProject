package com.hz.yk.spring.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by wuzheng.yk on 17/4/28.
 */
@Configuration
@ComponentScan("com.hz.yk.spring.async")
@EnableAsync        //开启异步任务支持
public class TaskExecutorConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);	//可异步开启的线程数
        taskExecutor.setMaxPoolSize(15);	//最大线程数
        taskExecutor.setQueueCapacity(10);	//每个线程可排队数
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        // TODO Auto-generated method stub
        return null;
    }

}
