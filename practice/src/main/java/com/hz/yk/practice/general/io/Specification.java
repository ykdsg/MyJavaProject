package com.hz.yk.practice.general.io;

/**
 * @author wuzheng.yk
 * @date 2020/3/10
 */
@FunctionalInterface
public interface Specification<T> {

    boolean test(T item);

}
