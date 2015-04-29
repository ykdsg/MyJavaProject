package com.hz.yk.yk.statemachine;

/**
 * @author wuzheng.yk
 *         Date: 15/4/29
 *         Time: 16:50
 */
public interface IState {
    void power(Aircon1 ac);

    void cool(Aircon1 ac);

    String name();
}
