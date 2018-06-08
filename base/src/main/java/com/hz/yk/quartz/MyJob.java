package com.hz.yk.quartz;

import java.util.Map;

public class MyJob {
    public void execute(Map<String, String> jobData) {
        System.out.println("####################");
        System.out.println(jobData.get("type") + ":Test Job Run at :"
                + System.currentTimeMillis());
        System.out.println("####################");
    }
}
