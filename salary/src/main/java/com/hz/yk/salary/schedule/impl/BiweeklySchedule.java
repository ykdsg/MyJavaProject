package com.hz.yk.salary.schedule.impl;

import com.hz.yk.salary.schedule.PaymentSchedule;

import java.util.Calendar;

/**
 * 每2周支付
 */
public class BiweeklySchedule implements PaymentSchedule {

	@Override
	public boolean isPayDate(Calendar payDate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Calendar getPayPeriodStartDate(Calendar payPeriodEndDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
