package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.affiliation.UnionAffiliation;
import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.servicecharge.ServiceCharge;
import com.hz.yk.salary.transaction.impl.AddHourlyEmployee;
import com.hz.yk.salary.transaction.impl.ServiceChargeTransaction;

import java.util.Calendar;

public class TestAddServiceCharge {

	public static void main(String[] args) {
		PayrollDatabase payrollDatabase = new PayrollDatabase();
		int empid = 2;
		int memberId = 86;
		AddHourlyEmployee t = new AddHourlyEmployee(empid, "Bill", "Home", 12.25);
		t.execute();

		Employee e = payrollDatabase.getEmployee(empid);
		assert (e != null);

		UnionAffiliation af = new UnionAffiliation(memberId, 12.5);
		e.setAffiliation(af);

		payrollDatabase.addUnionMember(memberId, e);

		Calendar cal = Calendar.getInstance();
		cal.set(2016, 6, 30);
		ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, cal, 12.95);
		sct.execute();

		ServiceCharge sc = af.getServiceCharge(cal);
		assert (sc != null);
		assert (sc.getItsCharge() == 12.95);

		System.out.println("test success!");
	}
}
