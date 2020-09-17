package com.hz.yk.salary.transaction.test;

import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.classification.impl.SalariedClassification;
import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.payment.PaymentMethod;
import com.hz.yk.salary.payment.impl.HoldMethod;
import com.hz.yk.salary.schedule.PaymentSchedule;
import com.hz.yk.salary.schedule.impl.MonthlySchedule;
import com.hz.yk.salary.transaction.impl.AddSalariedEmployee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author wuzheng.yk
 * @date 2020/9/16
 */
public class TestAddSalariedEmployee {

    @Test
    public void testAdd() {
        int empId = 1;
        double salary = 1000.0;
        String name = "Bob";
        AddSalariedEmployee t = new AddSalariedEmployee(empId, name, "Home", salary);
        t.execute();
        Employee employee = PayrollDatabase.getEmployee(empId);
        assertEquals(name, employee.getName());

        PaymentClassification pc = employee.getClassification();
        SalariedClassification sc = (SalariedClassification) pc;
        assertNotNull(sc);

        assertEquals(salary, sc.getSalary(), 0.01);

        PaymentMethod pm = employee.getMethod();
        HoldMethod hm = (HoldMethod) pm;
        assertNotNull(hm);

        PaymentSchedule ps = employee.getSchedule();
        MonthlySchedule ms = (MonthlySchedule) ps;
        assertNotNull(ms);
    }

}
