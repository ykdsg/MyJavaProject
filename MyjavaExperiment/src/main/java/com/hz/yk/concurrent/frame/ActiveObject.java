package yk.concurrent.frame;

/**
 * Created by IntelliJ IDEA.
 * User: yangke
 * Date: 11-8-21
 * Time: обнГ2:36
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
