package com.hz.yk.concurrent.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by wuzheng.yk on 17/3/21.
 */
public class TASLock { //test and set lock 尝试去set 锁
    AtomicBoolean state = new AtomicBoolean(false);
    void lock() {
        while (true) {
            if (state.compareAndSet(state.get(),true)) {
                return;
            }
        }
    }
    void unLock() {
        state.set(false);
    }
}
