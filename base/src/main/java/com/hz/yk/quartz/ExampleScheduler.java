package com.hz.yk.quartz;

public class ExampleScheduler {

    public static void main(String[] args) throws Exception {
        final MyJobDetail detail1 = new MyJobDetail("job1", MyJob.class) {
            {
                getJobData().put("type", "job1");
            }
        };
        final MyJobDetail detail2 = new MyJobDetail("job2", MyJob.class) {
            {
                getJobData().put("type", "job2");
            }
        };
        final MyTrigger trigger1 = new MyTrigger() {
            {
                setNextFireTime(System.currentTimeMillis() + 3000L);
            }
        };
        final MyTrigger trigger2 = new MyTrigger() {
            {
                setNextFireTime(System.currentTimeMillis() + 1000L);
            }
        };

        MyScheduler scheduler = new MyScheduler();
        scheduler.schedulerJob(detail1, trigger1);
        scheduler.schedulerJob(detail2, trigger2);

        scheduler.start();
        Thread.sleep(10000L);
        scheduler.halt();
    }

}
