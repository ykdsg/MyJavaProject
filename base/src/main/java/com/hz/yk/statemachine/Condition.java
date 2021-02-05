package com.hz.yk.statemachine;

/**
 * 条件，表示是否允许到达某个状态
 *
 * @author wuzheng.yk
 * @date 2021/1/31
 */
public interface Condition<C> {

    boolean isSatisfied(C context);

    default String name() {
        return this.getClass().getSimpleName();
    }

}
