package com.hz.yk.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * MCS队列锁也是为每个线程分配一个节点，节点中任然包含一个locked属性，和CLH队列锁不同，MCS队列锁使用一个真正的队列来保存等待线程，
 * 因此节点中还包含一个next属性，并且locked属性的含义也不一样，在这里表示该线程是否应该被阻塞，线程将循环探测自己节点的locked属性，直到该属性被前续节点的线程修改为false。
 * 线程调用lock后，首先获取自己对应的节点node，并将node设置为队列尾，并返回前续节点，如果前续节点不为空，则表明线程应该等待：线程首先将node的locked设置为true，表示自己将被阻塞，然后
 * 置前续节点的next指向node，然后就开始循环直到node的locked属性被设置为false。 线程在调用unlock后，首先获取自己对应的节点node，如果node的next为空，则尝试将队列尾设置到空，如果成功
 * 则说明队列已经为空，则退出；否则则说明队列尾发生了变化，需要等待其它线程设置node的next属性，最后设置node的next的locked属性，并退出。 MCS队列锁和CLH队列锁具有相同的特点，前续节点
 * 状态的改变只会影响到后续的节点，不同点是MCS队列锁是在本地cache自旋等待。
 * Created by wuzheng.yk on 17/3/21.
 */
public class MCSLock {

    public static class MCSNode {

        volatile MCSNode next;
        volatile boolean isLocked = true;
    }

    private static final ThreadLocal<MCSNode>                          NODE    = new ThreadLocal<MCSNode>();
    @SuppressWarnings("unused")
    private volatile MCSNode                                           queue;
    private static final AtomicReferenceFieldUpdater<MCSLock, MCSNode> UPDATER = AtomicReferenceFieldUpdater.newUpdater(MCSLock.class,
                                                                                                                        MCSNode.class,
                                                                                                                        "queue");

    public void lock() {
        MCSNode currentNode = new MCSNode();
        NODE.set(currentNode);
        MCSNode preNode = UPDATER.getAndSet(this, currentNode);
        if (preNode != null) {
            preNode.next = currentNode;
            while (currentNode.isLocked) {

            }
        }
    }

    public void unlock() {
        MCSNode currentNode = NODE.get();
        if (currentNode.next == null) {
            if (UPDATER.compareAndSet(this, currentNode, null)) {

            } else {
                while (currentNode.next == null) {// 队列尾发生了改变，必然有新的节点正在或者将要添加进来，因此循环等待
                }
            }
        currentNode.next.isLocked = false;
        currentNode.next = null;
        }
    }
}
