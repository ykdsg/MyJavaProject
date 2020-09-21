package com.hz.yk.salary.affiliation;

import com.hz.yk.salary.pay.Paycheck;

import java.util.Optional;

public class NoAffiliation implements Affiliation {

	@Override
	public double calculateDeductions(Paycheck paycheck) {
		return 0.0;
	}

	@Override
	public Optional<Integer> getMemberId() {
		return Optional.empty();
	}
}
