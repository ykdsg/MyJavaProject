package com.hz.yk.salary.payment;

import com.hz.yk.salary.pay.Paycheck;

/**
 * 支付方式
 */
public interface PaymentMethod {

	public void pay(Paycheck paycheck);
}
