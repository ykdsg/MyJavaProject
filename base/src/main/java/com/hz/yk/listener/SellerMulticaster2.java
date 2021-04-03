package com.hz.yk.listener;

import com.hz.yk.listener.multicaster.Multicaster;

/**
 * @author wuzheng.yk
 * @date 2021/3/16
 */
public class SellerMulticaster2 extends Multicaster<DeliverEventListener> {

    void deliverGoods() {
        listeners.onDeliver();
    }

    public static void main(String[] args) {
        SellerMulticaster2 seller = new SellerMulticaster2();
        // 对卖家添加发货事件监听器
        seller.addListener(() -> System.out.println("用户 张三 收到发货通知"));
        seller.addListener(() -> System.out.println("快递员 小王 收到发货通知"));

        // 卖家发货
        seller.deliverGoods();
    }
}
