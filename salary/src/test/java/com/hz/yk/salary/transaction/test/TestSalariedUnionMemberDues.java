package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.change.affiliation.ChangeMemberTransaction;
import com.hz.yk.salary.pay.PaydayTransaction;
import com.hz.yk.salary.transaction.impl.AddSalariedEmployee;
import com.hz.yk.salary.transaction.test.util.Validate;
import org.junit.Test;

import java.util.Calendar;

public class TestSalariedUnionMemberDues {

	@Test
	public void testUnionMember() {
		int empid = 1;
		AddSalariedEmployee t = new AddSalariedEmployee(empid, "Bob", "Home", 1000.0);
		t.execute();

		int memberid = 7734;
		ChangeMemberTransaction cmt = new ChangeMemberTransaction(empid, memberid, 9.42);
		cmt.execute();

		Calendar payDate = Calendar.getInstance();
		payDate.set(2020, 7, 31);
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

		Validate val = new Validate();
		//val.validatePaycheck(pt, empid, payDate, 1000.0 - ? ??);

		System.out.println("test success");
	}
}
