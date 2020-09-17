package com.hz.yk.salary.transaction.impl;

import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.classification.impl.SalariedClassification;
import com.hz.yk.salary.schedule.PaymentSchedule;
import com.hz.yk.salary.schedule.impl.MonthlySchedule;

/**
 * 增加月薪员工
 */
public class AddSalariedEmployee extends AddEmployeeTemplateTransaction {

	private double itsSalary;

	public AddSalariedEmployee(int empid, String name, String address, double salary) {
		super(empid, name, address);
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
