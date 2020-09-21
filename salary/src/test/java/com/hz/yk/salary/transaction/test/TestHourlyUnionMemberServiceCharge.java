package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.change.affiliation.ChangeMemberTransaction;
import com.hz.yk.salary.pay.Paycheck;
import com.hz.yk.salary.pay.PaydayTransaction;
import com.hz.yk.salary.transaction.impl.AddHourlyEmployee;
import com.hz.yk.salary.transaction.impl.ServiceChargeTransaction;
import com.hz.yk.salary.transaction.impl.TimeCardTransaction;
import org.junit.Test;

import java.util.Calendar;

public class TestHourlyUnionMemberServiceCharge {

	@Test
	public void test() {
		int empid = 1;
		AddHourlyEmployee t = new AddHourlyEmployee(empid, "Bill", "Home", 15.24);
		t.execute();

		int memberid = 7734;
		ChangeMemberTransaction cmt = new ChangeMemberTransaction(empid, memberid, 9.42);
		cmt.execute();

		Calendar payDate = Calendar.getInstance();
		payDate.set(2016, 7, 8);

		ServiceChargeTransaction sct = new ServiceChargeTransaction(memberid, payDate, 19.42);
		sct.execute();

		TimeCardTransaction tct = new TimeCardTransaction(payDate, 8.0, empid);
		tct.execute();

		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

		Paycheck pc = pt.getPayCheck(empid);
		assert (pc != null);
		assert (pc.getPayPeriodEndDate() == payDate);
		System.out.println("pc.getPayPeriodEndDate()" + pc.getPayPeriodEndDate().getTime());
		assert (pc.getGrossPay() == 8 * 15.24);
		System.out.println("pc.getGrossPay():" + pc.getGrossPay());
		//		assert("Hold".equals(pc.getField("Disposition")))  ;
		assert (pc.getDeductions() == (9.42 + 19.42));
		System.out.println("pc.getDeductions():" + pc.getDeductions());
		assert (pc.getNetPay() == ((8 * 15.24) - (9.42 + 19.42)));
		System.out.println("pc.getNetPay():" + pc.getNetPay());

		System.out.println("test success!");
	}
}
