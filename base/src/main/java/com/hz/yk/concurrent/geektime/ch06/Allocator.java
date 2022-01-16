package com.hz.yk.concurrent.geektime.ch06;

import java.util.HashSet;
import java.util.Set;

/**
 * 同时申请进入"临界区"的2个对象
 *
 * @author wuzheng.yk
 * @date 2022/1/15
 */
public class Allocator {

    private final Set<Object> als = new HashSet<>();

    //unified application resources
    public synchronized void apply(Object param1, Object param2) {
        while (als.contains(param1) || als.contains(param2)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        als.add(param1);
        als.add(param2);
    }

    //unified free resources
    public synchronized void free(Object param1, Object param2) {
        als.remove(param1);
        als.remove(param2);
        notifyAll();
    }

}
