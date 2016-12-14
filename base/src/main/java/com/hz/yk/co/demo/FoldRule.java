package com.hz.yk.co.demo;

/**
 * 叠加
 * Created by wuzheng.yk on 16/12/14.
 */
public class FoldRule implements Rule {
    private final Rule[] rules;

    public FoldRule(Rule[] rules) {
        this.rules = rules;
    }

    @Override
    public boolean apply(RuleContext facts, Variant result) {
        int discount = 1;
        boolean isApply = false;
        for (Rule rule : rules) {
            if (rule.apply(facts, result)) {
                if (result.getDiscount() != 0) {
                    discount = discount * result.getDiscount();
                }
                isApply = true;
            }
        }
        result.setDiscount(discount);
        return isApply;
    }
}
