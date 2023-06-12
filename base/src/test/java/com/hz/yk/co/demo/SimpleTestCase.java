package com.hz.yk.co.demo;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by wuzheng.yk on 16/12/14.
 */
public class SimpleTestCase {

    private Rule getRule() {
        final Rule gold_member = MyRules.discountByMember("gold", 10);
        final Rule silver_member = MyRules.discountByMember("silver", 5);
        final Rule platinum_member = MyRules.discountByMember("platinum", 20);
        final Rule by_member = MyRules.any(new Rule[]{platinum_member,
                gold_member, silver_member});


        final Rule is_female = MyRules.isGender("female");
        final Rule is_female_day = MyRules.isMonth(Calendar.MARCH)
                .and(MyRules.isDay(8));
        final Rule female_discount = is_female.and(is_female_day)
                .then(MyRules.discount(5));

        final Rule tvspeaker = MyRules.purchased(new String[]{"tv","speaker"})
                .then(MyRules.discount(5));
        final Rule tvspeakerdvd = MyRules.purchased(new String[]{"tv","speaker","dvd"})
                .then(MyRules.discount(7));
        final Rule by_purchase = MyRules.max(new Rule[]{tvspeakerdvd, tvspeaker});

        final Rule final_discount = MyRules.fold(new Rule[]{
                by_member, female_discount, by_purchase
        });
        return final_discount;
    }

    /**
     * 没有符合任何条件的时候
     */
    @Test
    public void test0() {
        final RuleContext mrc = new RuleContext();
        final VariantResult result = new VariantResult();
        assertFalse(getRule().apply(mrc, result));
    }

    /**
     * 金牌会员的优惠
     */
    @Test
    public void test1(){
        final RuleContext mrc = new RuleContext();
        mrc.setMemberType("gold");

        final VariantResult result = new VariantResult();
        assertTrue(getRule().apply(mrc, result));
        assertEquals(10, result.getDiscount());
    }


    /**
     *  白金会员，女性 的优惠
     */
    @Test
    public void test2(){
        final RuleContext mrc = new RuleContext();
        mrc.setMemberType("platinum");
        mrc.setGender("female");

        final VariantResult result = new VariantResult();
        assertTrue(getRule().apply(mrc, result));
        assertEquals(20, result.getDiscount());
    }


    /**
     * 白金会员，女性，3.8节的优惠
     */
    @Test
    public void test3(){
        final RuleContext mrc = new RuleContext();
        mrc.setMemberType("platinum");

        mrc.setGender("female");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.MARCH);
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        mrc.setCreateDate(calendar);

        final VariantResult result = new VariantResult();
        assertTrue(getRule().apply(mrc, result));
        assertEquals(20*5, result.getDiscount());
    }

    /**
     * 白金会员，女性，3.8节,特定商品（tv,speaker）的优惠
     */
    @Test
    public void test4(){
        final RuleContext mrc = new RuleContext();
        mrc.setMemberType("platinum");

        mrc.setGender("female");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.MARCH);
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        mrc.setCreateDate(calendar);

        mrc.setItemList(Lists.newArrayList("tv","speaker"));
        final VariantResult result = new VariantResult();
        assertTrue(getRule().apply(mrc, result));
        assertEquals(20*5*5, result.getDiscount());

        mrc.setItemList(Lists.newArrayList("tv", "speaker", "dvd"));
        assertTrue(getRule().apply(mrc, result));
        assertEquals(20*5*7, result.getDiscount());

    }
}
