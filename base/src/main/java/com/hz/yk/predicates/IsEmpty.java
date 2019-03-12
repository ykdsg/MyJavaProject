package com.hz.yk.predicates;

/**
 * @author wuzheng.yk
 * @date 2018-12-23
 */
public class IsEmpty implements SPredicate {

    @Override
    public boolean is(String s) {return s.length() == 0;}
}
