package com.hz.yk.salary.schedule.impl;

import com.hz.yk.salary.schedule.PaymentSchedule;

import java.util.Calendar;

/**
 * 每月支付
 */
public class MonthlySchedule implements PaymentSchedule {

	public boolean isLastDayOfMonth(Calendar date) {
		int m1 = date.get(Calendar.MONTH);
		date.add(Calendar.DATE, 1);
		int m2 = date.get(Calendar.MONTH);
		return (m1 != m2);
	}

	@Override
	public boolean isPayDate(Calendar payDate) {
		return isLastDayOfMonth(payDate);
	}

	@Override
	public Calendar getPayPeriodStartDate(Calendar payPeriodEndDate) {
		System.out.println(payPeriodEndDate.getTime());
		Calendar startDate = Calendar.getInstance();
		startDate.set(Calendar.DATE, 1);
		System.out.println(startDate.getTime());
		return startDate;
	}
}
