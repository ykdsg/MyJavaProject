package com.hz.yk.co.demo;

/**
 * Created by wuzheng.yk on 16/12/13.
 */
public class IfElseRule implements Rule {
    private Rule cond;
    private Rule consequence;
    private Rule alternative;

    public IfElseRule(Rule cond, Rule consequence, Rule alternative) {
        this.cond = cond;
        this.consequence = consequence;
        this.alternative = alternative;
    }

    @Override
    public boolean apply(RuleContext facts, VariantResult result) {
        if (cond.apply(facts, result)) {
            return consequence.apply(facts, result);
        } else {
            return alternative.apply(facts, result);
        }
    }
}
