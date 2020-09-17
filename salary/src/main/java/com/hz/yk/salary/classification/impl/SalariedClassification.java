package com.hz.yk.salary.classification.impl;

import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.pay.Paycheck;

public class SalariedClassification extends PaymentClassification {

	private double itsSalary;

	public SalariedClassification(double salary) {
		itsSalary = salary;
	}

	public double getSalary() {
		return itsSalary;
	}

	@Override
	public double calculatePay(Paycheck paycheck) {
		return itsSalary;
	}
}
