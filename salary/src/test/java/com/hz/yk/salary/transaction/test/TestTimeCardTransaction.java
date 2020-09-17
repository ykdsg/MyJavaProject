package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.classification.impl.HourlyClassification;
import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.timecard.TimeCard;
import com.hz.yk.salary.transaction.impl.AddHourlyEmployee;
import com.hz.yk.salary.transaction.impl.TimeCardTransaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestTimeCardTransaction {

	@Test
	public void testTimeCard() {
		int empid = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empid, "Bill", "Home", 15.11);
		t.execute();

		Calendar cal = Calendar.getInstance();
		cal.set(2016, 6, 29);
		TimeCardTransaction tct = new TimeCardTransaction(cal, 8.0, empid);
		tct.execute();
		Employee e = PayrollDatabase.getEmployee(empid);
		assert (e != null);
		PaymentClassification pc = e.getClassification();
		Assert.assertTrue(pc instanceof HourlyClassification);
		HourlyClassification hc = (HourlyClassification) pc;
		assertNotNull(hc);

		TimeCard tc = hc.getTimeCard(cal);
		assertNotNull(tc);
		assertEquals(8.0, tc.getHours(), 0.1);
	}
}
