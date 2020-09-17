package com.hz.yk.salary.transaction.impl;

import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.transaction.Transaction;

public class DeleteEmployeeTransaction implements Transaction {

	private int itsEmpid;

	public DeleteEmployeeTransaction(int empid) {
		itsEmpid = empid;
	}

	@Override
	public void execute() {
		PayrollDatabase.deleteEmployee(itsEmpid);
	}

}
