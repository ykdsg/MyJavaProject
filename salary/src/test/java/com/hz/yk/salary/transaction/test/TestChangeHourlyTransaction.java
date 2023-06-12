package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.change.classification.ChangeHourlyTransaction;
import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.classification.impl.HourlyClassification;
import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.schedule.PaymentSchedule;
import com.hz.yk.salary.schedule.impl.WeeklySchedule;
import com.hz.yk.salary.transaction.impl.AddCommissionedEmployee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestChangeHourlyTransaction {

	@Test
	public void testChangeHourly() {
		int empid = 3;
		AddCommissionedEmployee t = new AddCommissionedEmployee(empid, "Lance", "Home", 2500, 3.2);
		t.execute();

		ChangeHourlyTransaction cht = new ChangeHourlyTransaction(empid, 27.52);
		cht.execute();

		Employee e = PayrollDatabase.getEmployee(empid);
		assertNotNull(e);
		PaymentClassification pc = e.getClassification();
		assertNotNull(pc);
		assertTrue(pc instanceof HourlyClassification);
		HourlyClassification hc = (HourlyClassification) pc;

		assertEquals(27.52, hc.getHourlyRate(), 0.01);
		PaymentSchedule ps = e.getSchedule();
		assertTrue(ps instanceof WeeklySchedule);

	}
}
