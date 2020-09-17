package com.hz.yk.salary.change.classification;

import com.hz.yk.salary.change.ChangeClassificationTransaction;
import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.classification.impl.HourlyClassification;
import com.hz.yk.salary.schedule.PaymentSchedule;
import com.hz.yk.salary.schedule.impl.WeeklySchedule;

public class ChangeHourlyTransaction extends ChangeClassificationTransaction {

	private double hourlyRate;

	private HourlyClassification hourlyClassification;
	private WeeklySchedule weeklySchedule;

	public ChangeHourlyTransaction(int empid, double hourlyRate) {
		super(empid);
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
