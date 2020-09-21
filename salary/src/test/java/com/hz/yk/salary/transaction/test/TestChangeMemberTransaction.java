package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.affiliation.Affiliation;
import com.hz.yk.salary.affiliation.UnionAffiliation;
import com.hz.yk.salary.change.affiliation.ChangeMemberTransaction;
import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.transaction.impl.AddHourlyEmployee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestChangeMemberTransaction {

	@Test
	public void testChanageMember() {
		int empid = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empid, "Bill", "Home", 15.25);
		t.execute();
		int memberid = 89;
		ChangeMemberTransaction cmt = new ChangeMemberTransaction(empid, memberid, 99.42);
		cmt.execute();

		Employee e = PayrollDatabase.getEmployee(empid);
		assertNotNull(e);
		Affiliation af = e.getAffiliation();
		assertNotNull(af);
		assertTrue(af instanceof UnionAffiliation);
		UnionAffiliation uf = (UnionAffiliation) af;
		assert (uf.getDues() == 99.42);
		Employee member = PayrollDatabase.getUnionMember(memberid);
		assert (member != null);
		assertEquals(e, member);

	}
}
