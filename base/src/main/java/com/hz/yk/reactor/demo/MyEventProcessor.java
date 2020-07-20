package com.hz.yk.reactor.demo;

/**
 * @author wuzheng.yk
 * @date 2020/6/19
 */
public interface MyEventProcessor {

    void register(MyEventListener<String> eventListener);

    void fireEvents(String... values);

    void processComplete();

    void shutdown();
}
