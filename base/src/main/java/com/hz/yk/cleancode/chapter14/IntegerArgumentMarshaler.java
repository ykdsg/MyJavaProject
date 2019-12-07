package com.hz.yk.cleancode.chapter14;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.hz.yk.cleancode.chapter14.ArgsException.ErrorCode.INVALID_INTEGER;
import static com.hz.yk.cleancode.chapter14.ArgsException.ErrorCode.MISSING_INTEGER;

/**
 * @author wuzheng.yk
 * @date 2019/11/17
 */
public class IntegerArgumentMarshaler implements ArgumentMarshaler {

    private int intValue = 0;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            intValue = Integer.parseInt(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_INTEGER);
        } catch (NumberFormatException e) {
            throw new ArgsException(INVALID_INTEGER, parameter);
        }
    }

    public static int getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof IntegerArgumentMarshaler)
            return ((IntegerArgumentMarshaler) am).intValue;
        else
            return 0;
    }
}
