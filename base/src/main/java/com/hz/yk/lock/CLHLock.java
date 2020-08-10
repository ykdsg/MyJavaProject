package com.hz.yk.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 无界队列锁，使用一个链表来组织线程
 * 假设L把锁，n个线程，那么锁的空间复杂度为O(L+n)
 *
 * @author wuzheng.yk
 * @date 2020/8/7
 */
public class CLHLock implements Lock {

    // 原子变量指向队尾
    private AtomicReference<QNode> tail;
    // 两个指针，一个指向自己的Node,一个指向前一个Node
    ThreadLocal<QNode> myNodeTL;
    ThreadLocal<QNode> myPreNodeTL;

    public CLHLock() {
        tail = new AtomicReference<QNode>(new QNode());
        myNodeTL = new ThreadLocal<QNode>() {

            @Override
            protected QNode initialValue() {
                return new QNode();
            }
        };
        myPreNodeTL = new ThreadLocal<QNode>() {

            @Override
            protected QNode initialValue() {
                return null;
            }
        };
    }

    @Override
    public void lock() {
        QNode node = myNodeTL.get();
        node.lock = true;
        // CAS原子操作，保证原子性
        QNode preNode = tail.getAndSet(node);
        myPreNodeTL.set(preNode);
        // volatile变量，能保证锁释放及时通知
        // 只对前一个节点的状态自旋，减少缓存一致性流量
        while (preNode.lock) {

        }
    }

    @Override
    public void unlock() {
        QNode node = myNodeTL.get();
        node.lock = false;
        // 把myNode指向preNode，目的是保证同一个线程下次还能使用这个锁，因为myNode原来指向的节点有它的后一个节点的preNode引用
        // 防止这个线程下次lock时myNode.get获得原来的节点
        myNodeTL.set(myPreNodeTL.get());
    }

    public static class QNode {

        volatile boolean lock;
    }

    @Override
    public String toString() {
        return "CLHLock";
    }

}
