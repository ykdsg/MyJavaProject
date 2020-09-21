package com.hz.yk.salary.change;

import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.transaction.Transaction;

/**
 * 使用了模板模式，对于所有变更操作，都必须要从数据库中去除对应id的Employee对象
 */
public abstract class ChangeEmployeeTransaction implements Transaction {

	private int itsEmpId;

	public abstract void change(Employee employee);

	public ChangeEmployeeTransaction(int empid) {
		itsEmpId = empid;
	}

	@Override
	public void execute() {
		Employee e = PayrollDatabase.getEmployee(itsEmpId);
		if (e != null) {
			change(e);
		}
	}

}
