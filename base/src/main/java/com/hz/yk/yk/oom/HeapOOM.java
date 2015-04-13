package com.hz.yk.yk.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有对象的实例分配都在Java堆上分配内存，堆大小由-Xmx和-Xms来调节
 *
 * 加上JVM参数-verbose:gc -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError，就能很快报出OOM：
 Exception in thread "main" java.lang.OutOfMemoryError: Java heap space

 并且能自动生成Dump。
 * @author wuzheng.yk
 *         Date: 13-2-19
 *         Time: 下午10:19
 */
public class HeapOOM {

    static class OOMObject{}

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while(true){
            list.add(new OOMObject());
        }
    }

}
