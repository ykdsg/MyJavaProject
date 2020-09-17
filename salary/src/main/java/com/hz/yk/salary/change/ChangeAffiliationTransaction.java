package com.hz.yk.salary.change;

import com.hz.yk.salary.affiliation.Affiliation;
import com.hz.yk.salary.entity.Employee;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {

	public abstract void recordMemberShip(Employee e);

	public abstract Affiliation getAffiliation();

	@Override
	public void change(Employee employee) {
		recordMemberShip(employee);
		employee.setAffiliation(getAffiliation());
	}

	public ChangeAffiliationTransaction(int empid) {
		super(empid);
	}
}
