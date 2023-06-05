package com.hz.yk.bank.common;

/**
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public class Result<T> {

    private T data;

    public Result(T data) {
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result(data);
    }
}
