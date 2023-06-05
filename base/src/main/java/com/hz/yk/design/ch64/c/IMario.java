package com.hz.yk.design.ch64.c;

/**
 * @author wuzheng.yk
 * @date 2023/4/24
 */

import com.hz.yk.design.ch64.State;

/**
 * 所有状态类的接口
 */
public interface IMario {

    State getName();

    //以下是定义的事件
    void obtainMushRoom();

    void obtainCape();

    void obtainFireFlower();

    void meetMonster();
}
