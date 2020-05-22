package com.hz.yk.fockjoin.jmh2;

/**
 * @author wuzheng.yk
 * @date 2020/5/22
 */
public interface Calculator {

    /**
     * 把传进来的所有numbers 做求和处理
     *
     * @param numbers
     * @return 总和
     */
    long sumUp(long[] numbers);
}
