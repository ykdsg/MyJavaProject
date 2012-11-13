package com.hz.yk.concurrent.frame;

/**
 * 线程对象，封装了并发逻辑
 * Created by IntelliJ IDEA.
 * User: yangke
 * Date: 11-8-21
 * Time: 下午2:36
 * To change this template use File | Settings | File Templates.
 */
public class ActiveObject extends Thread {
    public ActiveObject() {
        _queue = new ActiveQueue();
        start();
    }

    public void enqueue(MethodRequest mr) {
        _queue.enqueue(mr);
    }

    public void run() {
        while (true) {
            MethodRequest mr = _queue.dequeue();
            mr.call();
        }
    }

    private ActiveQueue _queue;
}
