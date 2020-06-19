package com.hz.yk.fockjoin.jmh2.task;

import java.util.concurrent.Callable;

/**
 * @author wuzheng.yk
 * @date 2020/6/16
 */
public class SleepTask implements Callable<Long> {

    private long number;

    public SleepTask(long number) {
        this.number = number;
    }

    @Override
    public Long call() throws Exception {
        try {
            Thread.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number;
    }
}
