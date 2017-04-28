package com.hz.yk.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by wuzheng.yk on 17/4/28.
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("demoListener 收到消息:" + msg);
    }
}
