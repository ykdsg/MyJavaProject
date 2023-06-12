package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.pay.PaydayTransaction;
import com.hz.yk.salary.transaction.impl.AddHourlyEmployee;
import com.hz.yk.salary.transaction.test.util.Validate;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class TestPaySingleHourlyEmployeeNoTimeCards {

	@Test
	public void test() {
		int empid = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empid, "Bill", "Home", 15.25);
		t.execute();

		Calendar payDate = Calendar.getInstance();
		payDate.set(2020, 7, 2);
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

		Validate val = new Validate();
		val.validatePaycheck(pt.getPayCheck(empid), payDate, 0.0);

		System.out.println("test success!");
	}
}
