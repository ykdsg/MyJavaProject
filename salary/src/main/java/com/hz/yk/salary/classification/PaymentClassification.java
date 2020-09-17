package com.hz.yk.salary.classification;

import com.hz.yk.salary.pay.Paycheck;

import java.util.Calendar;

/**
 * 薪水计算方式
 */
public abstract class PaymentClassification {

    public abstract double calculatePay(Paycheck paycheck);

    public boolean isInPayPeriod(Calendar theDate, Paycheck pc) {
        Calendar payPeriodEndDate = Calendar.getInstance();
        payPeriodEndDate = pc.getPayPeriodEndDate();

        Calendar payPeriodStartDate = Calendar.getInstance();
        payPeriodStartDate = pc.getPayPeriodStartDate();

        Calendar calTheDate = Calendar.getInstance();

        int bigger = payPeriodStartDate.compareTo(calTheDate);
        int lower = payPeriodEndDate.compareTo(calTheDate);
        return (bigger >= 0) && (lower <= 0);
    }
}
