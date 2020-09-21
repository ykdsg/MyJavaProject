package com.hz.yk.salary.change.affiliation;

import com.hz.yk.salary.affiliation.Affiliation;
import com.hz.yk.salary.affiliation.NoAffiliation;
import com.hz.yk.salary.change.ChangeAffiliationTransaction;
import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;

import java.util.Optional;

/**
 * 脱离协会会员
 */
public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {

	public ChangeUnaffiliatedTransaction(int empid) {
		super(empid);
	}

	@Override
	public void recordMemberShip(Employee e) {
		Affiliation af = e.getAffiliation();
		Optional<Integer> afMemberId = af.getMemberId();
		if (!afMemberId.isPresent()) {
			return;
		}
		PayrollDatabase.removeUnionMember(afMemberId.get());

	}

	@Override
	public NoAffiliation getAffiliation() {
		return new NoAffiliation();
	}

}
