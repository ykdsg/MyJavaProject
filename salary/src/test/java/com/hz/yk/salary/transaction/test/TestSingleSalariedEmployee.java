package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.pay.Paycheck;
import com.hz.yk.salary.pay.PaydayTransaction;
import com.hz.yk.salary.transaction.impl.AddSalariedEmployee;

import java.util.Calendar;

public class TestSingleSalariedEmployee {

	public static void main(String[] args) {
		PayrollDatabase payrollDatabase = new PayrollDatabase();
		int empid = 1;
		AddSalariedEmployee t = new AddSalariedEmployee(empid, "Bob", "Home", 1000.0);
		t.execute();
		Calendar payDate = Calendar.getInstance();
		//�µ�Ϊ֧������
		payDate.set(2016, 7, 31);
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();
		Paycheck pc = pt.getPayCheck(empid);
		assert (pc != null);
		assert (pc.getPayDate() == payDate);
		assert (pc.getGrossPay() == 1000.0);
		//		assert(pc.getField("Disposition").equals("Hold"));
		assert (pc.getDeductions() == 0.0);
		assert (pc.getNetPay() == 1000.0);

		System.out.println("test success!");
	}
}
