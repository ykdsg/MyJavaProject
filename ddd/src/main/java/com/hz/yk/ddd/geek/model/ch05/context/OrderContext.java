package com.hz.yk.ddd.geek.model.ch05.context;

import com.hz.yk.ddd.geek.model.ch05.models.Column;
import com.hz.yk.ddd.geek.model.ch05.models.User;

/**
 * @author wuzheng.yk
 * @date 2021/11/22
 */
public interface OrderContext {

    interface Buyer {

        void placeOrder(Column column);
    }

    Buyer asBuyer(User user);

}

