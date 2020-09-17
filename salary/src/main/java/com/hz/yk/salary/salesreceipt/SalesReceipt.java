package com.hz.yk.salary.salesreceipt;

import java.util.Calendar;

/**
 * 销售凭条
 */
public class SalesReceipt {

	private Calendar itsDate;
	private int itsAmount;

	public SalesReceipt(Calendar date, int amount) {
		itsDate = date;
		itsAmount = amount;
	}

	public Calendar getDate() {
		return itsDate;
	}

	public int getAmount() {
		return itsAmount;
	}
}
