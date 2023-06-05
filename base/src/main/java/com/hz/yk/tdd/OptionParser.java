package com.hz.yk.tdd;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2023/6/5
 */
interface OptionParser {

    Object parse(List<String> arguments, Option option);
}
