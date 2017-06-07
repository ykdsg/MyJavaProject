package com.hz.yk.co.demo;

/**
 * 把两个rule的bool值进行逻辑与
 * 类似地，OrRule用来进行逻辑或
 * Created by wuzheng.yk on 16/12/13.
 */
public class AndRule implements Rule{
    private Rule rule1;
    private Rule rule2;

    public AndRule(Rule rule1, Rule rule2) {
        this.rule1 = rule1;
        this.rule2 = rule2;
    }

    @Override
    public boolean apply(RuleContext facts, VariantResult result) {
        if (!rule1.apply(facts, result)) {
            return false;
        }
        if (!rule2.apply(facts, result)) {
            return false;
        }
        return true;
    }
}
