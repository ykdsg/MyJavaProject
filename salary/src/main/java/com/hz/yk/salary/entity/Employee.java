package com.hz.yk.salary.entity;

import com.hz.yk.salary.affiliation.Affiliation;
import com.hz.yk.salary.affiliation.NoAffiliation;
import com.hz.yk.salary.classification.PaymentClassification;
import com.hz.yk.salary.pay.Paycheck;
import com.hz.yk.salary.payment.PaymentMethod;
import com.hz.yk.salary.schedule.PaymentSchedule;

import java.util.Calendar;

public class Employee {

    private PaymentSchedule itsSchedule;
    private PaymentClassification itsClassification;
    private PaymentMethod itsPaymentMethod;
    private Affiliation itsAffiliation;

    private int itsEmpid;
    private String itsName;
    private String itsAddress;

    public Employee(int empid, String name, String address) {
        itsEmpid = empid;
        itsName = name;
        itsAddress = address;
        itsAffiliation = new NoAffiliation();
        itsClassification = null;
        itsSchedule = null;
        itsPaymentMethod = null;
    }

    public void setSchedule(PaymentSchedule paymentSchedule) {
        this.itsSchedule = paymentSchedule;
    }

    public PaymentSchedule getSchedule() {
        System.out.println(this.itsSchedule);
        return this.itsSchedule;
    }

    public void setClassification(PaymentClassification paymentClassification) {
        this.itsClassification = paymentClassification;
    }

    public PaymentClassification getClassification() {
        System.out.println(this.itsClassification);
        return this.itsClassification;
    }

    public void setMethod(PaymentMethod paymentMethod) {
        itsPaymentMethod = paymentMethod;
    }

    public PaymentMethod getMethod() {
        return itsPaymentMethod;
    }

    public String getName() {
        return itsName;
    }

    public void setName(String name) {
        itsName = name;
    }

    public String getAddress() {
        return itsAddress;
    }

    public void setAddress(String address) {
        itsAddress = address;
    }

    public void setAffiliation(Affiliation affiliation) {
        this.itsAffiliation = affiliation;
    }

    public Affiliation getAffiliation() {
        return this.itsAffiliation;
    }

    public boolean isPayDate(Calendar date) {
        return itsSchedule.isPayDate(date);
    }

    public void payDay(Paycheck pc) {
        Calendar payDate = pc.getPayPeriodEndDate();
        double grossPay = itsClassification.calculatePay(pc);
        double deductions = itsAffiliation.calculateDeductions(pc);
        double netPay = grossPay - deductions;
        pc.setGrossPay(grossPay);
        pc.setNetPay(netPay);
        pc.setDeductions(deductions);
        itsPaymentMethod.pay(pc);

    }

    public Calendar getPayPeriodStartDate(Calendar payPeriodEndDate) {
        return itsSchedule.getPayPeriodStartDate(payPeriodEndDate);
    }

    @Override
    public String toString() {
        return "Employee [paymentSchedule=" + itsSchedule + ", paymentClassification=" + itsClassification
               + ", paymentMethod=" + itsPaymentMethod + ", itsEmpid=" + itsEmpid + ", itsName=" + itsName
               + ", itsAddress=" + itsAddress + "]";
    }

}
