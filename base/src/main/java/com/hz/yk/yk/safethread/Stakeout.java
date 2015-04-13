package com.hz.yk.yk.safethread;

/**
 * 监控线程
 * Created by IntelliJ IDEA.
 * User: yangke
 * Date: 11-8-21
 * Time: 下午6:06
 * To change this template use File | Settings | File Templates.
 */
public class Stakeout extends Thread {
    public static boolean keepchecking = true;  // 持续监控标志
    boolean laststatus;     //保存上次监控状态
    int maydeadtimes = 0;  //监控线程可能死亡的计数器
    int maydeadtimeout = 3;//定义判断线程死亡的边界条件
    int deadtimes = 0;     //监控线程死亡次数的计数器
    int deadtimeout = 3;   //定义判断线程不正常的边界条件
    ATask a;

    Stakeout() {
        start();
    }

    public void run() {
        schedule();
        while (keepchecking) {
            laststatus = a.sign;
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("M is Interrupted!");
            }
            System.out.println("M read A status = " + a.sign);
            //如果过了一段时间记录的状态与a中的状态相同，说明可能存在线程死亡的情况
            if (laststatus == a.sign) {
                // 线程可能死亡的次数超过设定值
                if (++maydeadtimes >= maydeadtimeout) {
                    //实际线程死亡的次数
                    if (++deadtimes >= deadtimeout) {
                        System.out.println("Alert! A is unstable, M will stop it");
                        a = null;
                        break;
                    } else {
                        System.out.println("A is deaded!");
                        schedule();
                        System.out.println("M is restarting A!\n____________________________\n");
                    }
                }
            } else {
                maydeadtimes = 0;
            }
        }
    }

    /**
     * 初始化任务
     */
    private void schedule() {
       ATask a = new ATask(this);
    }
}
