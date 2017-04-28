package com.hz.yk.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by wuzheng.yk on 17/4/28.
 */
public class DemoEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;

    private String msg;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
