package com.yk.akka.demo1;

import java.io.Serializable;

/**
 * 招呼体,里面有打的什么招呼
 * Created by wuzheng.yk on 2017/8/1.
 */
public class Greeting implements Serializable {

    private static final long serialVersionUID = -523594763318360726L;
    public final String message;
    public Greeting(String message) {
        this.message = message;
    }

}
