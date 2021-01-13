package com.hz.yk.spring.conditional;

/**
 * Created by wuzheng.yk on 17/4/28.
 */
public class FirstConditionService implements ConditinalServiceInteface {

    public String description() {
        return "第一个条件成立的Service";
    }
}
