package com.hz.yk.reactor.demo;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2020/6/19
 */
public interface MyEventListener<T> {

    void onEvents(List<T> chunk);

    void processComplete();
}
