package com.hz.yk.salary.payment.impl;

import com.hz.yk.salary.pay.Paycheck;
import com.hz.yk.salary.payment.PaymentMethod;

public class HoldMethod implements PaymentMethod {

	@Override
	public void pay(Paycheck paycheck) {
		System.out.println("gross pay:" + paycheck.getGrossPay());
		System.out.println("deductions pay:" + paycheck.getDeductions());
		System.out.println("net pay:" + paycheck.getNetPay());

	}

}
