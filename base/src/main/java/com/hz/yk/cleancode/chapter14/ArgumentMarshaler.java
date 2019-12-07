package com.hz.yk.cleancode.chapter14;

import java.util.Iterator;

/**
 * @author wuzheng.yk
 * @date 2019/11/17
 */
public interface ArgumentMarshaler {

    void set(Iterator<String> currentArgument) throws ArgsException;

}
