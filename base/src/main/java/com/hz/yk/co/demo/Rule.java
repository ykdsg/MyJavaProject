package com.hz.yk.co.demo;


/**
 * Created by wuzheng.yk on 16/12/13.
 */
public interface Rule {
    /**
     * 返回的boolean值表现这个rule是否可用
     * @param facts rule所有需要的上下文信息
     * @param result rule 产生的结果
     * @return
     */
    boolean apply(RuleContext facts, VariantResult result);

    default Rule and(Rule rule) {
        return new AndRule(this, rule);
    }

    default Rule then(Rule rule) {
        return new IfElseRule(this, rule, new NilRule());
    }
}
