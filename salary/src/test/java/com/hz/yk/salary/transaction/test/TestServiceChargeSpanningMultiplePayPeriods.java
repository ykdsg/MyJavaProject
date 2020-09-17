package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.change.affiliation.ChangeMemberTransaction;
import com.hz.yk.salary.pay.Paycheck;
import com.hz.yk.salary.pay.PaydayTransaction;
import com.hz.yk.salary.transaction.impl.AddHourlyEmployee;
import com.hz.yk.salary.transaction.impl.ServiceChargeTransaction;
import com.hz.yk.salary.transaction.impl.TimeCardTransaction;

import java.util.Calendar;

/*
 * ����������Ҫ֤ʵ��ǰ֧���ڼ���ķ������û�б��۳���
 */
public class TestServiceChargeSpanningMultiplePayPeriods {

	public static void main(String[] args) {
		int empid = 1;
		//���ĸ�����Ϊ�ӵ��ԱÿСʱӦ������
		AddHourlyEmployee t = new AddHourlyEmployee(empid, "Bill", "Home", 15.24);
		t.execute();

		int memberid = 7734;
		ChangeMemberTransaction cmt = new ChangeMemberTransaction(empid, memberid, 9.42);
		cmt.execute();

		//��������ʱ�䣬���ھ�Ϊ����
		Calendar earlyDate = Calendar.getInstance();
		earlyDate.set(2016, 7, 1);
		Calendar payDate = Calendar.getInstance();
		payDate.set(2016, 7, 8);
		Calendar lateDate = Calendar.getInstance();
		lateDate.set(2016, 7, 15);

		ServiceChargeTransaction sct = new ServiceChargeTransaction(memberid, earlyDate, 19.42);
		sct.execute();
		ServiceChargeTransaction sctEarly = new ServiceChargeTransaction(memberid, earlyDate, 100.0);
		sctEarly.execute();
		ServiceChargeTransaction sctLate = new ServiceChargeTransaction(memberid, lateDate, 200.0);
		sctLate.execute();

		TimeCardTransaction tct = new TimeCardTransaction(payDate, 8.0, empid);
		tct.execute();

		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

		Paycheck pc = pt.getPayCheck(empid);
		assert (pc != null);
		assert (pc.getPayPeriodEndDate() == payDate);
		assert (pc.getDeductions() == 8 * 15.24);
		//		assert("Hold".equals(pc.getField("Disposition")));
		assert (pc.getDeductions() == (9.42 + 19.42));
		assert (pc.getNetPay() == ((8 * 15.24) - 9.42 + 19.42));
		System.out.println("test success!");
	}
}
