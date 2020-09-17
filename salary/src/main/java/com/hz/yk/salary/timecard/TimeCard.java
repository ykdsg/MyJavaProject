package com.hz.yk.salary.timecard;

import java.util.Calendar;

public class TimeCard {

	private Calendar itsDate;
	private double itsHours;

	public TimeCard(Calendar date, double hours) {
		itsDate = date;
		itsHours = hours;
	}

	public Calendar getDate() {return itsDate;}

	public double getHours() {return itsHours;}

}
