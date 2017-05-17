package com.hz.yk.concurrent.lock;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 独占锁
 * Created by wuzheng.yk on 2017/5/16.
 */
public class Mutex implements Lock, java.io.Serializable{
    private static final long serialVersionUID = 1L;
    // The sync object does all the hard work. We just forward to it
    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    // 支持中断式的获取 lock
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }
    // 尝试获取 lock
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    /**
     * 尝试 带 timeout 的获取 lock
     */
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    /** 释放lock */
    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked(){
        return sync.inHeldExclusively();
    }
    public boolean hasQueuedThreads(){
        return sync.hasQueuedThreads();
    }

    // internal helper class
    static class Sync extends AbstractQueuedSynchronizer {

        private static final long serialVersionUID = 7718109004686693316L;

        // report whether in locked state
        protected boolean inHeldExclusively(){ // 判断 lock 是否被占用
            return getState() == 1;
        }
        // 获取 lock
        // Acquire the lock if state is zero
        public boolean tryAcquire(int acquires){
            assert acquires == 1; // Otherwise unsed
            if(compareAndSetState(0, 1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        // 释放 lock
        // Releses the lock by setting state to zero
        protected boolean tryRelease(int release){
            assert release == 1; // Otherwise unused
            if(getState() == 0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // Provides a Condition
        Condition newCondition(){
            return new ConditionObject();
        }

        // Deserializes properly
        private void readObject(ObjectInputStream s)throws IOException, ClassNotFoundException{
            s.defaultReadObject();
            setState(0); // reset to unlocked state
        }
    }
}
