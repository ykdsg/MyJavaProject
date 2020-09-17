package com.hz.yk.salary.change;

import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.schedule.PaymentSchedule;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {

	public ChangeClassificationTransaction(int empid) {
		super(empid);
	}

	public abstract PaymentClassification getClassification();

	public abstract PaymentSchedule getSchedule();

	@Override
	public void change(Employee employee) {
		employee.setClassification(getClassification());
		employee.setSchedule(getSchedule());
	}
}
