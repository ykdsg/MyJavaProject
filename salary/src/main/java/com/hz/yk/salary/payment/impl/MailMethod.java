package com.hz.yk.salary.payment.impl;

import com.hz.yk.salary.pay.Paycheck;
import com.hz.yk.salary.payment.PaymentMethod;

public class MailMethod implements PaymentMethod {

	private String itsAddress;

	public MailMethod(String address) {
		itsAddress = address;
	}

	public String getItsAddress() {
		return itsAddress;
	}

	public void setItsAddress(String itsAddress) {
		this.itsAddress = itsAddress;
	}

	@Override
	public void pay(Paycheck paycheck) {

	}

}
