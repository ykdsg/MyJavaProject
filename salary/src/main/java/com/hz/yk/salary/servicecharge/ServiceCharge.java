package com.hz.yk.salary.servicecharge;

import java.util.Calendar;

/**
 * 服务费
 */
public class ServiceCharge {

	private double itsCharge;
	private Calendar itsDate;

	public ServiceCharge(Calendar date, double charge) {
		itsCharge = charge;
		itsDate = date;
	}

	public double getItsCharge() {
		return itsCharge;
	}

	public void setItsCharge(double itsCharge) {
		this.itsCharge = itsCharge;
	}

	public Calendar getItsDate() {
		return itsDate;
	}

	public void setItsDate(Calendar itsDate) {
		this.itsDate = itsDate;
	}
}
