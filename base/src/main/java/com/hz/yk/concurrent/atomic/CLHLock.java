package com.hz.yk.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * 锁由多个CLHNode 对象组成的虚拟链表表示，之所以称为虚拟链表，是因为CLHNode 之间并没有类似于next指针之类的引用，CLHNode 之间通过锁的一个本地线程（ThreadLocal）变量LOCAL
 * 相连，preNode 指向当前节点的前驱节点，即当前线程的前一个线程。而链表的尾节点则通过锁AtomicReferenceFieldUpdater<CLHLock, CLHNode>类型的tail成员变量指向，
 * 即tail指向加入到申请锁的队列中的最近一个线程。当一个线程申请锁时：
 * 首先会实例化一个CLHNode 节点，并将其设置为自己的本地线程变量LOCAL中；然后利用 UPDATER.getAndSet(this, node); 得到 前一个节点 其实就是实例化的 CLHNode 的节点node
 * 然后在此node上自旋。
 * 释放锁时：
 * 本地变量中获得node节点 然后进行tail的指向，释放锁 然后归还对象node。
 * Created by wuzheng.yk on 17/3/21.
 */
public class CLHLock {
    public static class CLHNode {
        private volatile boolean isLocked = true;
        //CLH算法中，每个申请锁的线程通过一个CLHNode 对象表示，
        //CLHNode 中有一个**volatile ****boolean**类型的成员变量isLocked ，
        //isLocked 为true，则表示对应的线程已经获取到了锁或者正在等待获取锁；
        //isLocked 为false，则表示对应的线程已经释放了锁。
    }
    @SuppressWarnings("unused")
    private volatile CLHNode tail;
    private static final ThreadLocal<CLHNode> LOCAL = new ThreadLocal<CLHNode>();
    private static final AtomicReferenceFieldUpdater<CLHLock, CLHNode> UPDATER = AtomicReferenceFieldUpdater
            .newUpdater(CLHLock.class, CLHNode.class, "tail");
    public void lock() {
        CLHNode node = new CLHNode();
        LOCAL.set(node);
        CLHNode preNode = UPDATER.getAndSet(this, node);
        if (preNode != null) {
            while (preNode.isLocked) {
            }
            preNode = null;
            LOCAL.set(node);
        }
    }
    public void unlock() {
        CLHNode node = LOCAL.get();
        if (!UPDATER.compareAndSet(this, node, null)) {
            node.isLocked = false;
        }
        node = null;
    }
}
