package com.hz.yk.cleancode.chapter14;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.hz.yk.cleancode.chapter14.ArgsException.ErrorCode.MISSING_STRING;

/**
 * @author wuzheng.yk
 * @date 2019/11/17
 */
public class StringArgumentMarshaler implements ArgumentMarshaler {

    private String stringValue = "";

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringValue = currentArgument.next();
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_STRING);
        }
    }

    public static String getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof StringArgumentMarshaler)
            return ((StringArgumentMarshaler) am).stringValue;
        else
            return "";
    }
}
