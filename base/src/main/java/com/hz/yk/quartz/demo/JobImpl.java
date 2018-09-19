package com.hz.yk.quartz.demo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * @author wuzheng.yk
 * @date 2018/9/3
 */
public class JobImpl implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("job impl running");
    }
}
