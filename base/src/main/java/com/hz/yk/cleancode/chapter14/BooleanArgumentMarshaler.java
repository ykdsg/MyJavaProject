package com.hz.yk.cleancode.chapter14;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.hz.yk.cleancode.chapter14.ArgsException.ErrorCode.MISSING_BOOLEAN;

/**
 * @author wuzheng.yk
 * @date 2019/11/17
 */
public class BooleanArgumentMarshaler implements ArgumentMarshaler {

    private boolean booleanValue = false;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            booleanValue = Boolean.parseBoolean(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_BOOLEAN);
        }
    }

    public static boolean getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof BooleanArgumentMarshaler)
            return ((BooleanArgumentMarshaler) am).booleanValue;
        else
            return false;
    }
}
