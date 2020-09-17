package com.hz.yk.salary.transaction.impl;

import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.classification.impl.CommissionedClassification;
import com.hz.yk.salary.schedule.PaymentSchedule;
import com.hz.yk.salary.schedule.impl.BiweeklySchedule;

/**
 * 增加提成员工
 *
 * @author wuzheng.yk
 * @date 2020/9/17
 */
public class AddCommissionedEmployee extends AddEmployeeTemplateTransaction {

    private double itsCommissionRate;
    private double itsSalary;

    public AddCommissionedEmployee(int itsEmpid, String itsName, String itsAddress, double itsCommissionRate,
                                   double itsSalary) {
        super(itsEmpid, itsName, itsAddress);
        this.itsCommissionRate = itsCommissionRate;
        this.itsSalary = itsSalary;
    }

    @Override
    public PaymentClassification getClassification() {
        return new CommissionedClassification(itsSalary, itsCommissionRate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new BiweeklySchedule();
    }
}
