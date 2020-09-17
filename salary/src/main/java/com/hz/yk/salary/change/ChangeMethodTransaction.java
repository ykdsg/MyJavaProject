package com.hz.yk.salary.change;

import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.payment.PaymentMethod;

public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {

	public ChangeMethodTransaction(int empid) {
		super(empid);
	}

	public abstract PaymentMethod getMethod();

	@Override
	public void change(Employee employee) {
		employee.setMethod(getMethod());
	}

}
