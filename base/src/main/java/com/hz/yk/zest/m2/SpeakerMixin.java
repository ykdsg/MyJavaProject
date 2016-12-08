package com.hz.yk.zest.m2;

/**
 * Created by wuzheng.yk on 16/12/1.
 */
public class SpeakerMixin implements Speaker {

    @Override
    public String sayHello() {
        return "Hello, World!";
    }

}
