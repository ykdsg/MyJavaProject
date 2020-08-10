package com.hz.yk.lock;

import java.util.Random;

/**
 * @author wuzheng.yk
 * @date 2020/7/31
 */
public class Backoff {

    private final int minDelay, maxDelay;

    private int limit;

    final Random random;

    public Backoff(int min, int max) {
        this.minDelay = min;
        this.maxDelay = max;
        limit = minDelay;
        random = new Random();
    }

    // 回退，线程等待一段时间
    public void backoff() throws InterruptedException {
        int delay = random.nextInt(limit);
        limit = Math.min(maxDelay, 2 * limit);
        Thread.sleep(delay);
    }
}
