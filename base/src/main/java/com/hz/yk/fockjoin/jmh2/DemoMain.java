package com.hz.yk.fockjoin.jmh2;

import org.openjdk.jmh.runner.RunnerException;

/**
 * @author wuzheng.yk
 * @date 2020/5/22
 */
public class DemoMain {

    public static void main(String[] args) throws RunnerException {
        FjDemoJMH demoJMH = new FjDemoJMH();
        demoJMH.N = 20000;
        for (int i = 0; i < 1000; i++) {
            demoJMH.init();
            long result = demoJMH.forkJoinTasks();
            System.out.println(result);
        }

    }
}
