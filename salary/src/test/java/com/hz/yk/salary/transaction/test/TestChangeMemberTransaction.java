package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.affiliation.Affiliation;
import com.hz.yk.salary.affiliation.UnionAffiliation;
import com.hz.yk.salary.change.affiliation.ChangeMemberTransaction;
import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.transaction.impl.AddHourlyEmployee;

public class TestChangeMemberTransaction {

	public static void main(String[] args) {
		PayrollDatabase payrollDatabase = new PayrollDatabase();
		int empid = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empid, "Bill", "Home", 15.25);
		t.execute();
		int memberid = 89;
		ChangeMemberTransaction cmt = new ChangeMemberTransaction(empid, memberid, 99.42);
		cmt.execute();

		Employee e = payrollDatabase.getEmployee(empid);
		assert (e != null);
		Affiliation af = e.getAffiliation();
		assert (af != null);
		UnionAffiliation uf = (UnionAffiliation) af;
		assert (uf != null);
		assert (uf.getDues() == 99.42);
		Employee member = payrollDatabase.getUnionMember(memberid);
		assert (member != null);
		assert (e == member);

		System.out.println("test success");
	}
}
