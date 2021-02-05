package com.hz.yk.statemachine;

/**
 * @author wuzheng.yk
 * @date 2021/1/31
 */
public interface Action<S, E, C> {

    void execute(S from, S to, E event, C context);

}
