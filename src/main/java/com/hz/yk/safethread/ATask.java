package com.hz.yk.safethread;

import org.jetbrains.annotations.Nullable;

/**
 * Created by IntelliJ IDEA.
 * User: yangke
 * Date: 11-8-21
 * Time: 下午6:04
 * To change this template use File | Settings | File Templates.
 */
public class ATask extends Thread {
    /**
     * A任务定期修改自己的dead标志，dead是一个布尔变量，理论上只要A没有死，
     * 那么dead肯定是周期变化的（和心跳概念差不多）
     */
    public boolean dead = false;
    Stakeout m;

    ATask(Stakeout m) {
        m = m;
        start();
    }

    public String getUserName(){
        return null;
    }


    public void run() {
        try {
            for (int i = -3; i <= 5; i++) {
                int j = 1 / i;   // 人为设置过程中陷阱
                dead = !dead;  // 活动状态
                System.out.println("i=" + i + ": status=" + dead);
                try {
                    sleep(2000);
                } catch (InterruptedException ie) {
                    System.out.println("A is Interrupted!");
                }
            }
            m.Keepchecking = false;  //A 正常结束后关闭监控线程
            System.out.println("A is Ending M");
        } catch (Exception e) {
            System.out.println("A become Exception!");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("线程："+Thread.currentThread()+" is over by gc~~~~~~~~~~~~~");
    }
}