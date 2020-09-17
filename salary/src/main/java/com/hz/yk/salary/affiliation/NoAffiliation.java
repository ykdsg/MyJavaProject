package com.hz.yk.salary.affiliation;

import com.hz.yk.salary.pay.Paycheck;

public class NoAffiliation implements Affiliation {

	@Override
	public double calculateDeductions(Paycheck paycheck) {
		return 0.0;
	}
}
