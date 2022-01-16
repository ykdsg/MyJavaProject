package com.hz.yk.concurrent.geektime.ch05;

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
    // another implemention see ch06/Allocator.java
    public synchronized boolean apply(Object param1, Object param2) {
        if (als.contains(param1) || als.contains(param2)) {
            return false;
        } else {
            als.add(param1);
            als.add(param2);
            return true;
        }
    }

    //unified free resources
    public synchronized void free(Object param1, Object param2) {
        als.remove(param1);
        als.remove(param2);
    }

}
