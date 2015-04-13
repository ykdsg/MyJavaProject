package com.hz.yk.yk.safethread;

/**
 * 通过给制定任务线程增加监控线程，可以很好地解决实时多任务环境下的安全监控问题，
 * 同时避免了核心调度线程事务过分复杂的问题。实践证明，该方法复杂度小，占用资源少，运行可靠，
 * 适合复杂条件下的多任务环境。
 * Created by IntelliJ IDEA.
 * User: yangke
 * Date: 11-8-21
 * Time: 下午6:08
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        byte[] justOn=new byte[1024*3927];
        Stakeout m = new Stakeout();
    }
}
