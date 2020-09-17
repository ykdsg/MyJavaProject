package com.hz.yk.salary.schedule.impl;

import com.hz.yk.salary.schedule.PaymentSchedule;

import java.util.Calendar;

/**
 * 每周支付
 */
public class WeeklySchedule implements PaymentSchedule {

	private int payDateFriday = 2;

	@Override
	public boolean isPayDate(Calendar payDate) {
		int date = payDate.get(Calendar.DAY_OF_WEEK);
		System.out.println(date);
		return payDateFriday == date;
	}

	@Override
	public Calendar getPayPeriodStartDate(Calendar payPeriodEndDate) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -6);
		return cal;
	}

}
