package com.hz.yk.co.demo;

/**
 * 排他性组合
 * Created by wuzheng.yk on 16/12/13.
 */
public class ExclusiveRule implements Rule{

    private final Rule[] rules;

    public ExclusiveRule(Rule[] rules) {
        this.rules = rules;
    }

    @Override
    public boolean apply(RuleContext facts, Variant result){
        for(Rule rule: rules){
            if(rule.apply(facts, result))
                return true;
        }
        return false;
    }
}
