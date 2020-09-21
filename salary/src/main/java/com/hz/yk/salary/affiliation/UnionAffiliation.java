package com.hz.yk.salary.affiliation;

import com.hz.yk.salary.pay.Paycheck;
import com.hz.yk.salary.servicecharge.ServiceCharge;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 协会从属关系
 */
public class UnionAffiliation implements Affiliation {

	private Calendar itsDate;
	private double itsCharge;

	private int itsMemberId;
	private double itsDues;

	private static Map<Calendar, ServiceCharge> itsServiceCharge = new HashMap<>();

	public UnionAffiliation(int memberId, double dues) {
		this.itsMemberId = memberId;
		this.itsDues = dues;
	}

	public void addServiceCharge(Calendar date, ServiceCharge charge) {
		itsServiceCharge.put(date, charge);
	}

	public ServiceCharge getServiceCharge(Calendar date) {
		return itsServiceCharge.get(date);
	}

	@Override
	public Optional<Integer> getMemberId() {
		return Optional.of(itsMemberId);
	}

	public double getDues() {
		return itsDues;
	}

	@Override
	public double calculateDeductions(Paycheck paycheck) {
		double totalDues = 0;
		int fridays = numberOfFridaysInPayPeriod(paycheck.getPayPeriodStartDate(), paycheck.getPayPeriodEndDate());
		totalDues = itsDues * fridays;

		for (ServiceCharge charge : itsServiceCharge.values()) {
			Calendar theDate = charge.getItsDate();
			Calendar startDate = paycheck.getPayPeriodStartDate();
			Calendar endDate = paycheck.getPayPeriodEndDate();
			int m1 = theDate.compareTo(startDate);
			int m2 = theDate.compareTo(endDate);
			if (m1 == 1 && m2 == -1) {
				totalDues += charge.getItsCharge();
			}
		}
		return totalDues;
	}

	public int numberOfFridaysInPayPeriod(Calendar payPeriodStart, Calendar payPeriodEnd) {
		int fridays = 0;
		for (Calendar day = payPeriodStart; day.compareTo(payPeriodEnd) <= 0; day.add(Calendar.DATE, 1)) {
			int friday = day.get(Calendar.DAY_OF_WEEK);
			if (friday == 2) {
				fridays++;
			}
		}
		System.out.println("����������ĸ���Ϊ��" + fridays + "��ÿ������������ܣ�����5˵��������ʱ�����䲻��");
		return fridays;
	}
}
