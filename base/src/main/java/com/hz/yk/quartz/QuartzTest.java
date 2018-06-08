package com.hz.yk.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author wuzheng.yk
 * @date 2018/6/8
 */
public class QuartzTest {

    public static void main(String[] args) {
        //1、创建JobDetial对象，并设置工作项
        JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class).withIdentity("myJob", "jobGroup").build();

        //2、创建Trigger对象
        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(
                2).repeatForever();
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger().withIdentity("Trigger_1",
                                                                                          "Trigger_Group_1");
        Trigger trigger = triggerBuilder.startAt(new Date()).withSchedule(schedBuilder).build();

        //3、创建Scheduler对象，并配置JobDetail和Trigger对象
        // 创建调度器
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            //4、并执行启动、关闭等操作
            scheduler.start();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        //                try {
        //                        //关闭调度器
        //                        scheduler.shutdown(true);
        //                } catch (SchedulerException e) {
        //                        e.printStackTrace();
        //                }
    }
}
