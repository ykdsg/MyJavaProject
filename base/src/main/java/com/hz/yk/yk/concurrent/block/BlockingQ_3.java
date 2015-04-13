package com.hz.yk.yk.concurrent.block;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wuzheng.yk
 *         Date: 13-11-8
 *         Time: ÏÂÎç12:30
 */
public class BlockingQ_3 {
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();
    private Queue<Object> linkedList = new LinkedList<Object>();
    private int maxLength = 10;

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            if (linkedList.size() == 0) {
                notEmpty.await();
            }
            if (linkedList.size() == maxLength) {
                notFull.signalAll();
            }
            return linkedList.poll();
        } finally {
            lock.unlock();
        }
    }

    public void offer(Object object) throws InterruptedException {
        lock.lock();
        try {
            if (linkedList.size() == 0) {
                notEmpty.signalAll();
            }
            if(linkedList.size() == maxLength){
                notFull.await();
            }
            linkedList.offer(object);
        } finally {
            lock.unlock();
        }
    }


}
