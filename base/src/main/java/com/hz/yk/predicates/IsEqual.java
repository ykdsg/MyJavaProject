package com.hz.yk.predicates;

/**
 * @author wuzheng.yk
 * @date 2018-12-23
 */
public class IsEqual implements SPredicate {

    private final String v;

    @Override
    public boolean is(String s) {return s.equals(v);}

    IsEqual(String v) {this.v = v;}
}
