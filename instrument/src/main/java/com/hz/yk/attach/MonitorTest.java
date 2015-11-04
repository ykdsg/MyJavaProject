package com.hz.yk.attach;

/**
 * Created by wuzheng.yk on 15/11/4.
 */
public class MonitorTest {

    public static void main(String[] args) throws InterruptedException {
        MonitorTest test = new MonitorTest();
        while (true) {
            test.test();
        }
    }

    void test(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wait.....");
    }

}
