package com.hz.yk.salary.change.affiliation;

import com.hz.yk.salary.affiliation.Affiliation;
import com.hz.yk.salary.affiliation.UnionAffiliation;
import com.hz.yk.salary.change.ChangeAffiliationTransaction;
import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {

	private int itsMemberId;
	private double itsDues;

	public ChangeMemberTransaction(int empid, int memberId, double dues) {
		super(empid);
		itsMemberId = memberId;
		itsDues = dues;
	}

	@Override
	public Affiliation getAffiliation() {
		return new UnionAffiliation(itsMemberId, itsDues);
	}

	@Override
	public void recordMemberShip(Employee e) {
		PayrollDatabase.addUnionMember(itsMemberId, e);
	}
}
