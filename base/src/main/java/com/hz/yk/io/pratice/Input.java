package com.hz.yk.io.pratice;

/**
 * @author wuzheng.yk
 * @date 2019/10/23
 */
public interface Input<T> {

    void transferTo(Output<T> output);

}
