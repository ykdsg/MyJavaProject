package com.hz.yk.io.pratice;

import java.io.IOException;

/**
 * @author wuzheng.yk
 * @date 2019-03-14
 */
public interface Input<T> {

    void transferTo(Output<T> output) throws IOException;
}
