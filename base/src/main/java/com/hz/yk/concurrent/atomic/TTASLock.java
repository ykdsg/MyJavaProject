package com.hz.yk.concurrent.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by wuzheng.yk on 17/3/21.
 */
public class TTASLock { // test for first then test set lock
    AtomicBoolean state = new AtomicBoolean(false);
    void lock() {
        while (true) {
            while (state.get()) {
            }
            if (state.compareAndSet(state.get(), true)) {
                return;
            }
        }
    }
    void unLock() {
        state.set(false);
    }
}
