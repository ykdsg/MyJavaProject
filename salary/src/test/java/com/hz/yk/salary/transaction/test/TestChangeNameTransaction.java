package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.change.ChangeNameTransaction;
import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.transaction.impl.AddHourlyEmployee;

public class TestChangeNameTransaction {

	public static void main(String[] args) {
		PayrollDatabase payrollDatabase = new PayrollDatabase();
		int empid = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empid, "Bill", "Home", 15.25);
		t.execute();
		ChangeNameTransaction cnt = new ChangeNameTransaction(empid, "Bob");
		cnt.execute();

		Employee e = payrollDatabase.getEmployee(empid);
		assert (e != null);
		assert (e.getName() == "Bob");

		System.out.println("test success!");
	}
}
