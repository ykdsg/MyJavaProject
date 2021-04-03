package com.hz.yk.listener;

import com.hz.yk.listener.multicaster.Listener;

/**
 * @author wuzheng.yk
 * @date 2021/3/16
 */
public interface DeliverEventListener extends Listener {

    void onDeliver();

}
