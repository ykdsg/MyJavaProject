package com.hz.yk.tdd;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2023/6/5
 */
public class BooleanOptionParser extends Args implements OptionParser<Boolean> {

    @Override
    public Boolean parse(List<String> arguments, Option option) {
        final int index = arguments.indexOf("-" + option.value());
        final boolean hasParament = index != -1 && index + 1 < arguments.size();
        if (hasParament && !arguments.get(index + 1).startsWith("-")) {
            throw new TooManyArgumentsException(option.value());
        }
        return index != -1;
    }
}
