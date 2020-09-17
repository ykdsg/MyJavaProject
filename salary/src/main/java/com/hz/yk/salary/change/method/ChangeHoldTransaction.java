package com.hz.yk.salary.change.method;

import com.hz.yk.salary.change.ChangeMethodTransaction;
import com.hz.yk.salary.payment.PaymentMethod;
import com.hz.yk.salary.payment.impl.HoldMethod;

public class ChangeHoldTransaction extends ChangeMethodTransaction {

	public ChangeHoldTransaction(int empid) {
		super(empid);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PaymentMethod getMethod() {
		return new HoldMethod();
	}

}
