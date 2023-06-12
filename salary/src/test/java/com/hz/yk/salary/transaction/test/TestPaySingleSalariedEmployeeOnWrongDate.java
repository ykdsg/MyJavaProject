package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.pay.Paycheck;
import com.hz.yk.salary.pay.PaydayTransaction;
import com.hz.yk.salary.transaction.impl.AddSalariedEmployee;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 *
 */
public class TestPaySingleSalariedEmployeeOnWrongDate {

	@Test
	public void testPayingOnWrongDate() {
		int empid = 1;
		AddSalariedEmployee t = new AddSalariedEmployee(empid, "Bob", "Home", 1000.0);
		t.execute();

		Calendar payDate = Calendar.getInstance();
		payDate.set(2016, 7, 30);
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

		Paycheck pc = pt.getPayCheck(empid);
		assertNull(pc);
	}

	@Test
	public void testPaying() {
		int empid = 1;
		AddSalariedEmployee t = new AddSalariedEmployee(empid, "Bob", "Home", 1000.0);
		t.execute();

		Calendar payDate = Calendar.getInstance();
		payDate.set(2016, Calendar.NOVEMBER, 30);
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

		Paycheck pc = pt.getPayCheck(empid);
		assertNotNull(pc);
	}
}
