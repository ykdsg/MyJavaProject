package com.hz.yk.concurrent.spin;

/**
 * Created by wuzheng.yk on 2017/6/15.
 */
public interface SpinLock {

    void lock();

    void unLock();
}
