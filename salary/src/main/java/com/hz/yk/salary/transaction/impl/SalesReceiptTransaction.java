package com.hz.yk.salary.transaction.impl;

import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.classification.impl.CommissionedClassification;
import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.salesreceipt.SalesReceipt;
import com.hz.yk.salary.transaction.Transaction;

import java.util.Calendar;

/**
 * 提成雇员登记销售凭条
 */
public class SalesReceiptTransaction implements Transaction {

	private Calendar itsDate;
	private int itsAmount;
	private int itsEmpid;

	public SalesReceiptTransaction(Calendar date, int amount, int empid) {
		itsDate = date;
		itsAmount = amount;
		itsEmpid = empid;
	}

	@Override
	public void execute() {
		Employee e = PayrollDatabase.getEmployee(itsEmpid);

		if (e != null) {
			PaymentClassification pc = e.getClassification();
			CommissionedClassification cc = (CommissionedClassification) pc;
			if (cc != null) {
				cc.addSalesReceipt(new SalesReceipt(itsDate, itsAmount));
			} else {
				System.out.println("tried to add salesreceipt to non-commission employee");
			}

		} else {
			System.out.println("no such employee.");
		}

	}
}
