package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.pay.Paycheck;
import com.hz.yk.salary.pay.PaydayTransaction;
import com.hz.yk.salary.transaction.impl.AddSalariedEmployee;

import java.util.Calendar;

/*
 * ����������֤ʵ���PaydayTransaction����ʹ��������Ϊ��������ģ�ϵͳ�Ͳ�֧���ӵ��Ա��
 */
public class TestPaySingleSalariedEmployeeOnWrongDate {

	public static void main(String[] args) {
		PayrollDatabase payrollDatabase = new PayrollDatabase();
		int empid = 1;
		AddSalariedEmployee t = new AddSalariedEmployee(empid, "Bob", "Home", 1000.0);
		t.execute();

		Calendar payDate = Calendar.getInstance();
		//7��30�Ų����µף�����֧������
		payDate.set(2016, 7, 30);
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

		Paycheck pc = pt.getPayCheck(empid);
		assert (pc == null);
		System.out.println("test success,�������ڲ���֧����");
	}
}
