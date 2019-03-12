package com.hz.yk.predicates;

/**
 * @author wuzheng.yk
 * @date 2018-12-23
 */
public class OrPredicate implements SPredicate {

    private final SPredicate p1;
    private final SPredicate p2;

    public OrPredicate(SPredicate p1, SPredicate p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public boolean is(String s) {
        return p1.is(s) || p2.is(s);
    }
}
