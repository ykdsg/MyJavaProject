package com.hz.yk.junit.runner;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/**
 * Created by wuzheng.yk on 2018/4/26.
 */
public class LogRunListener extends RunListener {
    @Override
    public void testRunStarted(Description description) throws Exception {
        println("==>JUnit4 started with description: \n" + description);
        println();
    }
    @Override
    public void testRunFinished(Result result) throws Exception {
        println("==>JUnit4 finished with result: \n" + describe(result));
    }
    @Override
    public void testStarted(Description description) throws Exception{
        println("==>Test method started with description: " + description);
    }
    @Override
    public void testFinished(Description description) throws Exception {
        println("==>Test method finished with description: " + description);
        println();
    }
    @Override
    public void testFailure(Failure failure) throws Exception {
        println("==>Test method failed with failure: " + failure);
    }
    @Override
    public void testAssumptionFailure(Failure failure) {
        println("==>Test method assumption failed with failure: " + failure);
    }
    @Override
    public void testIgnored(Description description) throws Exception {
        println("==>Test method ignored with description: " + description);
        println();
    }
    private String describe(Result result) {
        StringBuilder builder = new StringBuilder();
        builder.append("\tFailureCount: " + result.getFailureCount())
               .append("\n");
        builder.append("\tIgnoreCount: " + result.getIgnoreCount())
               .append("\n");
        builder.append("\tRunCount: " + result.getRunCount())
               .append("\n");;
        builder.append("\tRunTime: " + result.getRunTime())
               .append("\n");
        builder.append("\tFailures: " + result.getFailures())
               .append("\n");;
        return builder.toString();
    }
    private void println() {
        System.out.println();
    }
    private void println(String content) {
        System.out.println(content);
    }
}
