package com.hz.yk.salary.affiliation;

import com.hz.yk.salary.pay.Paycheck;

/**
 * 从属组织
 */
public interface Affiliation {

	public double calculateDeductions(Paycheck paycheck);
}
