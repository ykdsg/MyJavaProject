package com.hz.yk.generic;

/**
 * @author wuzheng.yk
 * @date 2019-07-25
 */
public class Plate<T> {

    private T item;

    public Plate(T t) {item = t;}

    public void set(T t) {item = t;}

    public T get() {return item;}
}
