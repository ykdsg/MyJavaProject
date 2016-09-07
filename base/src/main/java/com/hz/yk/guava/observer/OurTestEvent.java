package com.hz.yk.guava.observer;

/**
 * @author yangke
 *         Date: 13-7-25
 *         Time: 下午3:07
 */
public class OurTestEvent {

    private final int message;

    public OurTestEvent(int message) {
        this.message = message;
    }

    public int getMessage() {
        return message;
    }
}
