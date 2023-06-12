package com.hz.yk.tdd;

import java.util.List;
import java.util.function.Function;

/**
 * @author wuzheng.yk
 * @date 2023/6/5
 */
public class SingleValueOptionParser<T> implements OptionParser<T> {

    Function<String, T> valuePraser;
    
    T defaultValue;

    public SingleValueOptionParser(Function<String, T> valuePraser, T defaultValue) {
        this.valuePraser = valuePraser;
        this.defaultValue = defaultValue;
    }

    @Override
    public T parse(List<String> arguments, Option option) {
        int index = arguments.indexOf("-" + option.value());
        if (index == -1) {
            return defaultValue;
        }
        if (index + 1 >= arguments.size() || arguments.get(index + 1).startsWith("-")) {
            throw new InsufficientArgumentsException(option.value());
        }
        if (index + 2 < arguments.size() && !arguments.get(index + 2).startsWith("-")) {
            throw new TooManyArgumentsException(option.value());
        }
        final String value = arguments.get(index + 1);
        return valuePraser.apply(value);
    }

}
