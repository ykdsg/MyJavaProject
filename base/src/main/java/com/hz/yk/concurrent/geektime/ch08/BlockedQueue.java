package com.hz.yk.concurrent.geektime.ch08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wuzheng.yk
 * @date 2022/1/16
 */
public class BlockedQueue<T> {

    Lock lock = new ReentrantLock();
    //条件变量：队列不满
    Condition notFull = lock.newCondition();
    //条件变量：
    Condition notEmpty = lock.newCondition();

    Queue<T> queue = new LinkedList<>();

    int limit = 100;

    void enq(T x) {
        lock.lock();
        try {
            while (queue.size() >= limit) {
                //如果队列已满，等待队列不满
                notFull.await();
            }
            queue.add(x);
            //通知队列不空
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    T dep() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            final T result = queue.poll();
            notFull.signal();
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
