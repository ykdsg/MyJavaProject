package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.change.affiliation.ChangeMemberTransaction;
import com.hz.yk.salary.pay.PaydayTransaction;
import com.hz.yk.salary.transaction.impl.AddSalariedEmployee;
import com.hz.yk.salary.transaction.test.util.Validate;

import java.util.Calendar;

/*
 * ��������������һ����н��Ա������ת���һ��Э���Ա��Ȼ��֧���ù�Աнˮ��
 * ��ȷ���ӹ�Ա��нˮ�п۳���ѡ�
 */
public class TestSalariedUnionMemberDues {

	public static void main(String[] args) {
		int empid = 1;
		AddSalariedEmployee t = new AddSalariedEmployee(empid, "Bob", "Home", 1000.0);
		t.execute();

		//Э��id
		int memberid = 7734;
		ChangeMemberTransaction cmt = new ChangeMemberTransaction(empid, memberid, 9.42);
		cmt.execute();

		Calendar payDate = Calendar.getInstance();
		payDate.set(2016, 7, 31);
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

		Validate val = new Validate();
		//		val.validatePaycheck(pt, empid, payDate, 1000.0-???);

		System.out.println("test success");
	}
}
