package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.pay.PaydayTransaction;
import com.hz.yk.salary.transaction.impl.AddHourlyEmployee;
import com.hz.yk.salary.transaction.impl.TimeCardTransaction;
import com.hz.yk.salary.transaction.test.util.Validate;

import java.util.Calendar;

public class TestPaySingleHourlyEmployeeWithTimeCardsSpanningTwoPayPeriods {

	public static void main(String[] args) {
		int empid = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empid, "Bill", "Home", 15.25);
		t.execute();

		Calendar payDate = Calendar.getInstance();
		payDate.set(2016, 7, 8);

		Calendar previousPayPeriod = Calendar.getInstance();
		previousPayPeriod.set(2016, 7, 1);

		TimeCardTransaction tc = new TimeCardTransaction(payDate, 2.0, empid);
		tc.execute();

		TimeCardTransaction tc2 = new TimeCardTransaction(previousPayPeriod, 5.0, empid);
		tc2.execute();

		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

		Validate val = new Validate();
		val.validatePaycheck(pt.getPayCheck(empid), payDate, 2 * 15.25);

		System.out.println("test success!");

	}
}
