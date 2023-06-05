package com.hz.yk.tdd;

import java.util.List;
import java.util.function.Function;

/**
 * @author wuzheng.yk
 * @date 2023/6/5
 */
public class IntOptionParser implements OptionParser {
     Function<String, Object> valuePraser ;
    public IntOptionParser(Function<String, Object> valuePraser) {
        this.valuePraser = valuePraser;
    }

    @Override
    public Object parse(List<String> arguments, Option option) {
        int index = arguments.indexOf("-" + option.value());
        final String value = arguments.get(index + 1);
        return valuePraser.apply(value);
    }

}
