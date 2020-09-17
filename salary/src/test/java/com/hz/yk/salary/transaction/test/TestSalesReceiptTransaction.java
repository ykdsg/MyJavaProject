package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.classification.impl.CommissionedClassification;
import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.salesreceipt.SalesReceipt;
import com.hz.yk.salary.transaction.impl.AddCommissionedEmployee;
import com.hz.yk.salary.transaction.impl.SalesReceiptTransaction;

import java.util.Calendar;

public class TestSalesReceiptTransaction {

	public static void main(String[] args) {
		PayrollDatabase payrollDatabase = new PayrollDatabase();
		int empid = 3;
		AddCommissionedEmployee t = new AddCommissionedEmployee(empid, "jack", "Home", 2500, 9.9);
		t.execute();

		Calendar cal = Calendar.getInstance();
		cal.set(2016, 6, 29);

		//param:date,amount,empid
		SalesReceiptTransaction srt = new SalesReceiptTransaction(cal, 10, empid);
		srt.execute();

		Employee e = payrollDatabase.getEmployee(empid);
		assert (e != null);

		PaymentClassification pc = e.getClassification();
		CommissionedClassification cc = (CommissionedClassification) pc;
		assert (cc != null);

		SalesReceipt sr = cc.getSalesReceipt(cal);
		assert (sr != null);
		assert (sr.getAmount() == 10);
		System.out.println("test success!");

	}
}
