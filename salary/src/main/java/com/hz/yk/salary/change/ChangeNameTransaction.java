package com.hz.yk.salary.change;

import com.hz.yk.salary.entity.Employee;

public class ChangeNameTransaction extends ChangeEmployeeTransaction {

	private String itsName;

	public ChangeNameTransaction(int empid, String name) {
		super(empid);
		itsName = name;
	}

	@Override
	public void change(Employee employee) {
		employee.setName(itsName);
	}
}
