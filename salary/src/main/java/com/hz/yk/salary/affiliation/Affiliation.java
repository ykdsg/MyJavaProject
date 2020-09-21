package com.hz.yk.salary.affiliation;

import com.hz.yk.salary.pay.Paycheck;

import java.util.Optional;

/**
 * 从属的组织
 */
public interface Affiliation {

	public double calculateDeductions(Paycheck paycheck);

	/**
	 * 获取组织中的成员id
	 *
	 * @return
	 */
	Optional<Integer> getMemberId();
}
