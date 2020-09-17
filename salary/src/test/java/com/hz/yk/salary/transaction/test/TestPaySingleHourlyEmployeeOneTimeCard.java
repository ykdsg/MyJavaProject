package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.pay.PaydayTransaction;
import com.hz.yk.salary.transaction.impl.AddHourlyEmployee;
import com.hz.yk.salary.transaction.impl.TimeCardTransaction;
import com.hz.yk.salary.transaction.test.util.Validate;

import java.util.Calendar;

public class TestPaySingleHourlyEmployeeOneTimeCard {

	public static void main(String[] args) {
		PayrollDatabase payrollDatabase = new PayrollDatabase();

		int empid = 2;
		;
		AddHourlyEmployee t = new AddHourlyEmployee(empid, "Bill", "Home", 15.25);
		t.execute();

		Calendar payDate = Calendar.getInstance();
		payDate.set(2016, 7, 2);

		TimeCardTransaction tc = new TimeCardTransaction(payDate, 2.0, empid);
		tc.execute();
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

		Validate val = new Validate();
		val.validatePaycheck(pt, empid, payDate, 30.5);

		System.out.println("test success!");
	}
}
