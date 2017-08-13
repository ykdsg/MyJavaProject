package com.yk.akka.demo1;

import java.io.Serializable;

/**
 * 打招呼的人
 * Created by wuzheng.yk on 2017/8/1.
 */
public class WhoToGreet implements Serializable {

    private static final long serialVersionUID = 4328461230426266041L;
    public final String who;
    public WhoToGreet(String who) {
        this.who = who;
    }

}
