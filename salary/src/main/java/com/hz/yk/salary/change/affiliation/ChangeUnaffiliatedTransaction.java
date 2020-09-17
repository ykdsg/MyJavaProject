package com.hz.yk.salary.change.affiliation;

import com.hz.yk.salary.affiliation.Affiliation;
import com.hz.yk.salary.affiliation.NoAffiliation;
import com.hz.yk.salary.affiliation.UnionAffiliation;
import com.hz.yk.salary.change.ChangeAffiliationTransaction;
import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {

	public ChangeUnaffiliatedTransaction(int empid) {
		super(empid);
	}

	@Override
	public void recordMemberShip(Employee e) {
		Affiliation af = e.getAffiliation();
		UnionAffiliation uf = (UnionAffiliation) af;
		int memberId = uf.getMemberId();
		PayrollDatabase.removeUnionMember(memberId);

	}

	@Override
	public NoAffiliation getAffiliation() {
		return new NoAffiliation();
	}

}
