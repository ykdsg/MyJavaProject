package com.hz.yk.ddd.geek.model.ch05.role;

import com.hz.yk.ddd.geek.model.ch05.models.Column;
import com.hz.yk.ddd.geek.model.ch05.models.Order;
import com.hz.yk.ddd.geek.model.ch05.models.Payment;
import com.hz.yk.ddd.geek.model.ch05.models.User;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2021/11/22
 */
public class Buyer {

    private User user;
    private List<Order> orders;
    private List<Payment> payments;

    public Buyer(User user) {
        this.user = user;
    }

    //订单上下文
    public void placeOrder(Column column) {

    }
}
