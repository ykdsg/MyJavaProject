package com.hz.yk.salary.classification.impl;

import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.pay.Paycheck;
import com.hz.yk.salary.timecard.TimeCard;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HourlyClassification extends PaymentClassification {

	private TimeCard timeCard;
	private double hourlyRate;

	private final static Map<Calendar, TimeCard> itsTimeCards = new HashMap<>();
	private final static List<TimeCard> timecards = new ArrayList<>();

	public HourlyClassification(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public void addTimeCard(TimeCard timeCard) {
		itsTimeCards.put(timeCard.getDate(), timeCard);
		timecards.add(timeCard);
	}

	public TimeCard getTimeCard(Calendar cal) {
		return itsTimeCards.get(cal);
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	@Override
	public double calculatePay(Paycheck pc) {
		double totalPay = 0;
		Calendar payPeriod = pc.getPayDate();

		for (TimeCard tc : timecards) {
			if (isInPayPeriod(tc, payPeriod)) {
				totalPay += calculatePayForTimeCard(tc);
			}
		}
		System.out.println("�����ӵ��Ա�ܵ�֧������Ϊ��" + totalPay);
		return totalPay;
	}

	public boolean isInPayPeriod(TimeCard tc, Calendar payPeriod) {
		Calendar payPeriodEndDate = payPeriod;
		payPeriod.set(Calendar.DATE, -5);
		Calendar payPeriodStartDate = payPeriod;
		Calendar timeCardDate = tc.getDate();
		int bigger = timeCardDate.compareTo(payPeriodStartDate);
		int litter = timeCardDate.compareTo(payPeriodEndDate);
		return (bigger >= 0) && (litter <= 0);
	}

	public double calculatePayForTimeCard(TimeCard tc) {
		double hours = tc.getHours();
		double overtime = max(0.0, hours - 8.0);
		double straightTime = hours - overtime;
		return straightTime * hourlyRate + overtime * hourlyRate * 1.5;
	}

	public double max(double zero, double div) {
		if (div > zero)
			return div;
		else
			return zero;
	}
}
