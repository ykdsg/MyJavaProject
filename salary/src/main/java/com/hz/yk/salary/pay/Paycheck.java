package com.hz.yk.salary.pay;

import java.util.Calendar;

public class Paycheck {

	private Calendar itsPayDate;
	private double itsGrossPay;
	private double itsDeductions;
	private double itsNetPay;
	private Calendar itsStartDate;

	public Paycheck(Calendar itsPayDate) {
		this.itsPayDate = itsPayDate;
	}

	public Paycheck(Calendar payDateStartPeriod, Calendar payDate) {
		itsStartDate = payDateStartPeriod;
		itsPayDate = payDate;
	}

	public void setGrossPay(double grossPay) {
		this.itsGrossPay = grossPay;
	}

	public double getGrossPay() {
		return this.itsGrossPay;
	}

	public void setDeductions(double deduction) {
		this.itsDeductions = deduction;
	}

	public double getDeductions() {
		return this.itsDeductions;
	}

	public void setNetPay(double netPay) {
		this.itsNetPay = netPay;
	}

	public double getNetPay() {
		return itsNetPay;
	}

	public Calendar getPayPeriodEndDate() {
		return itsPayDate;
	}

	public Calendar getPayPeriodStartDate() {
		return itsStartDate;
	}

	public Calendar getPayDate() {
		return itsPayDate;
	}
}
