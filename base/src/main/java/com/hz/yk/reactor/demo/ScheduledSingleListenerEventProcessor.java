package com.hz.yk.reactor.demo;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author wuzheng.yk
 * @date 2020/6/19
 */
public class ScheduledSingleListenerEventProcessor implements MyEventProcessor {

    private MyEventListener<String> eventListener;
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void register(MyEventListener<String> eventListener) {
        this.eventListener = eventListener;
    }

    @Override
    public void fireEvents(String... values) {
        //每个半秒发送一个事件
        executor.schedule(() -> eventListener.onEvents(Arrays.asList(values)), 500, TimeUnit.MILLISECONDS);
    }

    @Override
    public void processComplete() {
        executor.schedule(() -> eventListener.processComplete(), 500, TimeUnit.MILLISECONDS);
    }

    @Override
    public void shutdown() {
        this.executor.shutdownNow();
    }

}
