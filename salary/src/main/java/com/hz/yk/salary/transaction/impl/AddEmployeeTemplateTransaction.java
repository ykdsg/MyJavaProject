package com.hz.yk.salary.transaction.impl;

import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.database.PayrollDatabase;
import com.hz.yk.salary.entity.Employee;
import com.hz.yk.salary.payment.PaymentMethod;
import com.hz.yk.salary.payment.impl.HoldMethod;
import com.hz.yk.salary.schedule.PaymentSchedule;
import com.hz.yk.salary.transaction.Transaction;

/**
 * @author wuzheng.yk
 * @date 2020/9/16
 */
public abstract class AddEmployeeTemplateTransaction implements Transaction {

    private int itsEmpid;
    private String itsName;
    private String itsAddress;

    public AddEmployeeTemplateTransaction(int itsEmpid, String itsName, String itsAddress) {
        this.itsEmpid = itsEmpid;
        this.itsName = itsName;
        this.itsAddress = itsAddress;
    }

    public abstract PaymentClassification getClassification();

    public abstract PaymentSchedule getSchedule();

    @Override
    public void execute() {
        PaymentMethod pm = new HoldMethod();
        Employee e = new Employee(itsEmpid, itsName, itsAddress);
        e.setClassification(getClassification());
        e.setSchedule(getSchedule());
        e.setMethod(pm);
        PayrollDatabase.addEmployee(itsEmpid, e);
    }
}
