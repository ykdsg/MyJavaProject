package com.hz.yk.salary.change.method;

import com.hz.yk.salary.change.ChangeMethodTransaction;
import com.hz.yk.salary.payment.PaymentMethod;
import com.hz.yk.salary.payment.impl.MailMethod;

public class ChangeMailTransaction extends ChangeMethodTransaction {

	private String itsAddress;

	public ChangeMailTransaction(int empid, String address) {
		super(empid);
		itsAddress = address;
	}

	@Override
	public PaymentMethod getMethod() {
		return new MailMethod(itsAddress);
	}

}
