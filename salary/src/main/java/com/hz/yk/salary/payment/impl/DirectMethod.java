package com.hz.yk.salary.payment.impl;

import com.hz.yk.salary.pay.Paycheck;
import com.hz.yk.salary.payment.PaymentMethod;

public class DirectMethod implements PaymentMethod {

	private String itsBank;
	private int itsAccount;

	public DirectMethod(String itsBank, int itsAccount) {
		super();
		this.itsBank = itsBank;
		this.itsAccount = itsAccount;
	}

	public String getItsBank() {
		return itsBank;
	}

	public void setItsBank(String itsBank) {
		this.itsBank = itsBank;
	}

	public int getItsAccount() {
		return itsAccount;
	}

	public void setItsAccount(int itsAccount) {
		this.itsAccount = itsAccount;
	}

	@Override
	public void pay(Paycheck paycheck) {
		// TODO Auto-generated method stub

	}
}
