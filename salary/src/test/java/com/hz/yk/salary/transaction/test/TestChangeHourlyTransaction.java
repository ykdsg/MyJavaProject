package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.change.classification.ChangeHourlyTransaction;
import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.classification.impl.HourlyClassification;
import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.schedule.PaymentSchedule;
import com.hz.yk.salary.schedule.impl.WeeklySchedule;
import com.hz.yk.salary.transaction.impl.AddCommissionedEmployee;

public class TestChangeHourlyTransaction {

	public static void main(String[] args) {
		PayrollDatabase payrollDatabase = new PayrollDatabase();
		int empid = 3;
		AddCommissionedEmployee t = new AddCommissionedEmployee(empid, "Lance", "Home", 2500, 3.2);
		t.execute();

		ChangeHourlyTransaction cht = new ChangeHourlyTransaction(empid, 27.52);
		cht.execute();

		Employee e = payrollDatabase.getEmployee(empid);
		assert (e != null);
		PaymentClassification pc = e.getClassification();
		assert (pc != null);
		HourlyClassification hc = (HourlyClassification) pc;
		assert (hc != null);

		assert (hc.getHourlyRate() == 27.52);
		PaymentSchedule ps = e.getSchedule();
		WeeklySchedule ws = (WeeklySchedule) ps;
		assert (ws != null);

		System.out.println("test success!");
	}
}
