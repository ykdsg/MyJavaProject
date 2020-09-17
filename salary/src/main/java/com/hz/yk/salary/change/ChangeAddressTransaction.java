package com.hz.yk.salary.change;

import com.hz.yk.salary.entity.Employee;

public class ChangeAddressTransaction extends ChangeEmployeeTransaction {

	private String itsAddress;

	public ChangeAddressTransaction(int empid, String address) {
		super(empid);
		itsAddress = address;
	}

	@Override
	public void change(Employee employee) {
		employee.setAddress(itsAddress);
	}

}
