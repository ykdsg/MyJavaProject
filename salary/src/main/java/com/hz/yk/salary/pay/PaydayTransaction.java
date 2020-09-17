package com.hz.yk.salary.pay;

import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.transaction.Transaction;

import java.util.Calendar;
import java.util.Collection;

public class PaydayTransaction implements Transaction {

	private Calendar itsPayDate;

	private Paycheck[] itsPaychecks = new Paycheck[10];

	public PaydayTransaction(Calendar payDate) {
		itsPayDate = payDate;
	}

	@Override
	public void execute() {
		Collection<Integer> empIds = PayrollDatabase.getAllEmployeeId();

		for (Integer id : empIds) {
			int empId = (int) id;
			Employee e = PayrollDatabase.getEmployee(empId);
			if (e != null) {
				if (e.isPayDate(itsPayDate)) {
					System.out.println("发薪日：" + itsPayDate.getTime());
					Paycheck pc = new Paycheck(e.getPayPeriodStartDate(itsPayDate), itsPayDate);
					itsPaychecks[empId] = pc;
					e.payDay(pc);
				} else {
					System.out.println("还不到发薪日，" + itsPayDate.getTime());
				}
			}
		}

	}

	public Paycheck getPayCheck(int empId) {
		return itsPaychecks[empId];
	}

	public String getField(String dis) {
		return "";
	}
}
