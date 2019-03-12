package com.hz.yk.predicates;

import org.apache.commons.lang3.StringUtils;

/**
 * 假如我们希望实现一个Spredicate，它要判断"这个字符串是个小写字符串，或者等于hello"
 *
 * @author wuzheng.yk
 * @date 2018-12-23
 */
public class Predicate1 implements SPredicate {

    @Override
    public boolean is(String s) {

        //这样一来，我们没有重用IsEqual和IsLowercase这两个类的代码
        return StringUtils.isAllLowerCase(s) || s.equals("hello");
        //如果使用下面的这种方式，这样也是过程式的，非常死板。如果有不同的逻辑就需要创建Predicate2，Predicate3...
        //return new IsEqual().is(v) || new IsLowercase().is(v);

    }
}
