package com.hz.yk.salary.change.classification;

import com.hz.yk.salary.change.ChangeClassificationTransaction;
import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.classification.impl.SalariedClassification;
import com.hz.yk.salary.schedule.PaymentSchedule;
import com.hz.yk.salary.schedule.impl.MonthlySchedule;

public class ChangeSalariedTransaction extends ChangeClassificationTransaction {

	private int itsSalary;

	public ChangeSalariedTransaction(int empid, int salary) {
		super(empid);
		itsSalary = salary;
	}

	@Override
	public PaymentClassification getClassification() {
		return new SalariedClassification(itsSalary);
	}

	@Override
	public PaymentSchedule getSchedule() {
		return new MonthlySchedule();
	}

}
