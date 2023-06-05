package com.hz.yk.tdd;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2023/6/5
 */
public class BooleanOptionParser implements OptionParser {

    @Override
    public Object parse(List<String> arguments, Option option) {
        return arguments.contains("-" + option.value());
    }
}
