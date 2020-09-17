package com.hz.yk.salary.change.classification;

import com.hz.yk.salary.change.ChangeClassificationTransaction;
import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.classification.impl.CommissionedClassification;
import com.hz.yk.salary.schedule.PaymentSchedule;
import com.hz.yk.salary.schedule.impl.BiweeklySchedule;

public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {

	private int itsSalary;
	private double itsCommissionRate;

	public ChangeCommissionedTransaction(int empid, int salary, double commissionRate) {
		super(empid);
		itsSalary = salary;
		itsCommissionRate = commissionRate;
	}

	@Override
	public PaymentClassification getClassification() {
		return new CommissionedClassification(itsSalary, itsCommissionRate);
	}

	@Override
	public PaymentSchedule getSchedule() {
		return new BiweeklySchedule();
	}
}
