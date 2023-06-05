package com.hz.yk.ddd.geek.model;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2021/11/17
 */
public class Page<T> {

    private List<T> result;
    private int from;
    private int size;

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
