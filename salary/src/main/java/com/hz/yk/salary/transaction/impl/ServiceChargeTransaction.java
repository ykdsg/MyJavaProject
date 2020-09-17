package com.hz.yk.salary.transaction.impl;

import com.hz.yk.salary.affiliation.Affiliation;
import com.hz.yk.salary.affiliation.UnionAffiliation;
import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.servicecharge.ServiceCharge;
import com.hz.yk.salary.transaction.Transaction;

import java.util.Calendar;

public class ServiceChargeTransaction implements Transaction {

	private int itsMemberId;
	private Calendar itsDate;
	private double itsCharge;

	private PayrollDatabase payrollDatabase;

	public ServiceChargeTransaction(int memberId, Calendar date, double charge) {
		itsMemberId = memberId;
		itsDate = date;
		itsCharge = charge;
	}

	@Override
	public void execute() {
		payrollDatabase = new PayrollDatabase();
		Employee e = PayrollDatabase.getUnionMember(itsMemberId);
		Affiliation af = e.getAffiliation();

		UnionAffiliation uaf = (UnionAffiliation) af;
		ServiceCharge sc = new ServiceCharge(itsDate, itsCharge);
		uaf.addServiceCharge(itsDate, sc);
	}
}
