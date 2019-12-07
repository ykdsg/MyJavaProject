package com.hz.yk.cleancode.chapter14;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.hz.yk.cleancode.chapter14.ArgsException.ErrorCode.INVALID_DOUBLE;
import static com.hz.yk.cleancode.chapter14.ArgsException.ErrorCode.MISSING_DOUBLE;

/**
 * @author wuzheng.yk
 * @date 2019/11/17
 */
public class DoubleArgumentMarshaler implements ArgumentMarshaler {

    private double doubleValue = 0;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            doubleValue = Double.parseDouble(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_DOUBLE);
        } catch (NumberFormatException e) {
            throw new ArgsException(INVALID_DOUBLE, parameter);
        }
    }

    public static double getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof DoubleArgumentMarshaler)
            return ((DoubleArgumentMarshaler) am).doubleValue;
        else
            return 0;
    }
}
