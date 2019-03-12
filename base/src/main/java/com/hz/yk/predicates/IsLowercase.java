package com.hz.yk.predicates;

import org.apache.commons.lang.StringUtils;

/**
 * @author wuzheng.yk
 * @date 2018-12-23
 */
public class IsLowercase implements SPredicate {

    @Override
    public boolean is(String s) {
        return StringUtils.isAllLowerCase(s);
    }

}
