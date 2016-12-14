package com.hz.yk.co.demo;

/**
 * 取最大的优惠
 * Created by wuzheng.yk on 16/12/14.
 */
public class MaxRule implements Rule {
    private final Rule[] rules;

    public MaxRule(Rule[] rules) {
        this.rules = rules;
    }

    @Override
    public boolean apply(RuleContext facts, Variant result) {
        int maxDiscount = 0;
        Rule maxRule = null;
        for (Rule rule : rules) {
            if (rule.apply(facts, result) && result.getDiscount() > maxDiscount) {
                maxDiscount = result.getDiscount();
                maxRule = rule;
            }
        }
        if (maxRule == null) {
            return false;
        }
        return maxRule.apply(facts,result);
    }
}
