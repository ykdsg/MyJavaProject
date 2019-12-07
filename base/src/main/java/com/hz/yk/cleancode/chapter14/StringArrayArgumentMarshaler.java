package com.hz.yk.cleancode.chapter14;

import java.util.Iterator;

/**
 * @author wuzheng.yk
 * @date 2019/11/17
 */
public class StringArrayArgumentMarshaler implements ArgumentMarshaler {

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        //TODO: Auto-generated
    }

    public static String[] getValue(ArgumentMarshaler argumentMarshaler) {
        return new String[0];  //TODO: Auto-generated
    }
}
