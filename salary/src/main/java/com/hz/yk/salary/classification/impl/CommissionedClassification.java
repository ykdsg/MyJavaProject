package com.hz.yk.salary.classification.impl;

import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.pay.Paycheck;
import com.hz.yk.salary.salesreceipt.SalesReceipt;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CommissionedClassification extends PaymentClassification {

	private SalesReceipt salesReceipt;
	private double itsSalary;
	private double itsCommissionRate;

	private static Map<Calendar, SalesReceipt> itsSalesReceipt = new HashMap<>();

	public CommissionedClassification(double salary, double commissionRate) {
		itsSalary = salary;
		itsCommissionRate = commissionRate;
	}

	public void addSalesReceipt(SalesReceipt salesReceipt) {
		itsSalesReceipt.put(salesReceipt.getDate(), salesReceipt);
	}

	public SalesReceipt getSalesReceipt(Calendar cal) {
		return itsSalesReceipt.get(cal);
	}

	@Override
	public double calculatePay(Paycheck paycheck) {
		double temp = 2.2;
		return temp;
	}
}
