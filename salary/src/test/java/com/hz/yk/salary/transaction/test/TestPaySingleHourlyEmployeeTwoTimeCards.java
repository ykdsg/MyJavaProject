package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.pay.PaydayTransaction;
import com.hz.yk.salary.transaction.impl.AddHourlyEmployee;
import com.hz.yk.salary.transaction.impl.TimeCardTransaction;
import com.hz.yk.salary.transaction.test.util.Validate;

import java.util.Calendar;

/*
 * �����Թ���֤ʵϵͳ����Ϊ���ж��ʱ�俨�Ĺ�Ա����нˮ
 */
public class TestPaySingleHourlyEmployeeTwoTimeCards {

	public static void main(String[] args) {
		int empid = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empid, "Bill", "Home", 15.25);
		t.execute();
		Calendar payDate = Calendar.getInstance();
		payDate.set(2016, 7, 5);

		TimeCardTransaction tc = new TimeCardTransaction(payDate, 2.0, empid);
		tc.execute();

		payDate.set(2016, 7, 4);
		TimeCardTransaction tc2 = new TimeCardTransaction(payDate, 5.0, empid);
		tc2.execute();

		payDate.set(2016, 7, 8);
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

		Validate val = new Validate();
		val.validatePaycheck(pt.getPayCheck(empid), payDate, 7 * 15.25);

	}
}
