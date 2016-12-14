package com.hz.yk.co.demo;

/**
 * 不返回任何值，它永远都是一个不会被应用的规则（也就是说，apply()函数必然返回false）
 * Created by wuzheng.yk on 16/12/13.
 */
public class NilRule implements Rule{
    @Override
    public boolean apply(RuleContext facts, Variant result) {
        return false;
    }
}
