package com.hz.yk.co.demo;

import org.apache.shiro.util.CollectionUtils;

import java.util.Calendar;
import java.util.Objects;

/**
 * Created by wuzheng.yk on 16/12/14.
 */
public class MyRules {

    public static Rule discountByMember(String memberType, int discount) {
        return new Rule() {
            @Override
            public boolean apply(RuleContext facts, Variant result) {
                if (Objects.equals(facts.getMemberType(), memberType)) {
                    result.setDiscount(discount);
                    return true;
                }
                return false;
            }
        };
    }


    public static Rule any(Rule[] rules) {
        return new ExclusiveRule(rules);
    }

    public static Rule max(Rule[] rules) {
        return new MaxRule(rules);
    }

    public static Rule fold(Rule[] rules) {
        return new FoldRule(rules);
    }

    public static Rule discount(int discount) {
        return new Rule() {
            @Override
            public boolean apply(RuleContext facts, Variant result) {
                result.setDiscount(discount);
                return true;
            }
        };
    }
    /**
     * 根据性别选择规则
     * @param gender
     * @return
     */
    public static Rule isGender(String gender) {
        return new Rule() {
            @Override
            public boolean apply(RuleContext facts, Variant result) {
                if (Objects.equals(facts.getGender(), gender)) {
                    return true;
                }
                return false;
            }
        };
    }

    public static Rule isMonth(int month) {
        return new Rule() {
            @Override
            public boolean apply(RuleContext facts, Variant result) {
                if (facts.getCreateDate() != null && facts.getCreateDate().get(Calendar.MONTH) == month) {
                    return true;
                }
                return false;
            }
        };
    }

    public static Rule isDay(int day) {
        return new Rule() {
            @Override
            public boolean apply(RuleContext facts, Variant result) {
                if (facts.getCreateDate() != null && facts.getCreateDate().get(Calendar.DAY_OF_MONTH) == day) {
                    return true;
                }
                return false;
            }
        };
    }

    /**
     * 根据商品选择的规则
     * @param items
     * @return
     */
    public static Rule purchased(String... items) {
        return new Rule() {
            @Override
            public boolean apply(RuleContext facts, Variant result) {
                if (CollectionUtils.isEmpty(facts.getItemList())) {
                    return false;
                }
                for (String item : items) {
                    if (!facts.getItemList().contains(item)) {
                        return false;
                    }
                }
                return true;
            }
        };
    }

}
