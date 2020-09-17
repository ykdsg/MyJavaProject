package com.hz.yk.salary.schedule;

import java.util.Calendar;

/**
 * 支付时间表
 */
public interface PaymentSchedule {

	public boolean isPayDate(Calendar payDate);

	public Calendar getPayPeriodStartDate(Calendar payPeriodEndDate);
}
