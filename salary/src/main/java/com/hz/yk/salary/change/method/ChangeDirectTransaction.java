package com.hz.yk.salary.change.method;

import com.hz.yk.salary.change.ChangeMethodTransaction;
import com.hz.yk.salary.payment.PaymentMethod;
import com.hz.yk.salary.payment.impl.DirectMethod;

public class ChangeDirectTransaction extends ChangeMethodTransaction {

	private String itsBank;
	private int itsAccount;

	public ChangeDirectTransaction(int empid, String bank, int account) {
		super(empid);
		itsBank = bank;
		itsAccount = account;
	}

	@Override
	public PaymentMethod getMethod() {
		return new DirectMethod(itsBank, itsAccount);
	}
}
