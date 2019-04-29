package com.hz.yk.reactor.core.publisher;

/**
 * @author wuzheng.yk
 * @date 2019-04-26
 */
public interface MyEventListener {

    void onNewEvent(MyEventSource.MyEvent event);

    void onEventStopped();

}
