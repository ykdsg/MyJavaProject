package com.hz.yk.drools.demo2;

import org.kie.api.runtime.KieSession;

import static com.hz.yk.drools.DroolsUtil.getSession;

/**
 * https://abelyang.blog.csdn.net/article/details/53883650
 * 喝啤酒问题，小明去喝啤酒，啤酒搞活动，
 * 啤酒二元一瓶，
 * 两个空瓶可以再换一瓶啤酒，
 * 四个瓶盖也可以换一瓶啤酒，
 * 问小明花多少钱可以喝多少瓶啤酒？
 *
 * @author wuzheng.yk
 * @date 2021/6/8
 */
public class DrinkBee {

    private static void drink() {
        KieSession ks = getSession("drink-rules");
        Customer c1 = new Customer("奥巴马", 10);
        ks.insert(c1);
        int count = ks.fireAllRules();
        System.out.println("总执行了" + count + "条规则");
        System.out.println(c1.toString());
    }

    public static void main(String[] args) {
        drink();
    }
}
