package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.transaction.impl.AddCommissionedEmployee;
import com.hz.yk.salary.transaction.impl.DeleteEmployeeTransaction;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestDeleteEmployee {

	@Test
	public void testDelete() {
		int empid = 1;
		AddCommissionedEmployee t = new AddCommissionedEmployee(empid, "Bob", "Home", 2500.0, 3.2);
		t.execute();
		Employee employee = PayrollDatabase.getEmployee(empid);
		assertNotNull(employee);

		DeleteEmployeeTransaction dt = new DeleteEmployeeTransaction(empid);
		dt.execute();

		Employee delEmployee = PayrollDatabase.getEmployee(empid);
		assertNull(delEmployee);

		System.out.println("Test success!");
	}
}
