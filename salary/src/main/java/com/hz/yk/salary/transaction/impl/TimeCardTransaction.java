package com.hz.yk.salary.transaction.impl;

import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.classification.impl.HourlyClassification;
import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.timecard.TimeCard;
import com.hz.yk.salary.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

public class TimeCardTransaction implements Transaction {

	private static final Logger log = LoggerFactory.getLogger(TimeCardTransaction.class);

	private int itsEmpid;
	private Calendar itsDate;
	private double itsHours;

	public TimeCardTransaction(Calendar date, double hours, int empid) {
		itsEmpid = empid;
		itsDate = date;
		itsHours = hours;
	}

	@Override
	public void execute() {
		Employee employee = PayrollDatabase.getEmployee(itsEmpid);
		if (employee != null) {
			PaymentClassification pc = employee.getClassification();
			if (!(pc instanceof HourlyClassification)) {
				log.error("[TimeCardTransaction-execute]error,Tried to add TimeCard to non-hourly employee");
				throw new IllegalArgumentException("non-hourly employee,itsEmpid=" + itsEmpid);
			}
			HourlyClassification hc = (HourlyClassification) pc;
			hc.addTimeCard(new TimeCard(itsDate, itsHours));
		} else {
			log.error("no such employee");
		}
	}

}
