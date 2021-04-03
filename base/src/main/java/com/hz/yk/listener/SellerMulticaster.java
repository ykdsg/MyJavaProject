package com.hz.yk.listener;

import com.hz.yk.listener.multicaster.Multicaster;
import com.hz.yk.listener.multicaster.MulticasterSupport;

/**
 * @author wuzheng.yk
 * @date 2021/3/16
 */
public class SellerMulticaster extends MulticasterSupport<DeliverEventListener> {

    @Override
    protected Multicaster<DeliverEventListener> createMulticaster() {
        return new Multicaster<DeliverEventListener>() {};
    }

    void deliverGoods() {
        multicaster.listeners.onDeliver();
    }

    public static void main(String[] args) {
        SellerMulticaster seller = new SellerMulticaster();
        // 对卖家添加发货事件监听器
        seller.addListener(() -> System.out.println("用户 张三 收到发货通知"));
        seller.addListener(() -> System.out.println("快递员 小王 收到发货通知"));

        // 卖家发货
        seller.deliverGoods();
    }
}
