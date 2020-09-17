package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.pay.Paycheck;
import com.hz.yk.salary.pay.PaydayTransaction;
import com.hz.yk.salary.transaction.impl.AddHourlyEmployee;
import com.hz.yk.salary.transaction.impl.TimeCardTransaction;

import java.util.Calendar;

public class TestPaySingleHourlyEmployeeOnWrongDate {

	public static void main(String[] args) {

		int empid = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empid, "Bill", "Home", 15.25);
		t.execute();

		Calendar payDate = Calendar.getInstance();

		//3�Ų������壬�����ӵ㹤֧���ա�
		payDate.set(2016, 7, 3);

		TimeCardTransaction tc = new TimeCardTransaction(payDate, 9.0, empid);
		tc.execute();
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

		Paycheck pc = pt.getPayCheck(empid);
		assert (pc == null);

		System.out.println("test success!");
	}
}
