package com.hz.yk.salary.transaction.impl;

import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.classification.impl.HourlyClassification;
import com.hz.yk.salary.schedule.PaymentSchedule;
import com.hz.yk.salary.schedule.impl.WeeklySchedule;

/**
 * 增加按小时计费员工
 */
public class AddHourlyEmployee extends AddEmployeeTemplateTransaction {

	private double hourlyRate;

	public AddHourlyEmployee(int empid, String name, String address, double hourlyRate) {
		super(empid, name, address);

		this.hourlyRate = hourlyRate;
	}

	@Override
	public PaymentClassification getClassification() {
		return new HourlyClassification(hourlyRate);
	}

	@Override
	public PaymentSchedule getSchedule() {
		return new WeeklySchedule();
	}

}
