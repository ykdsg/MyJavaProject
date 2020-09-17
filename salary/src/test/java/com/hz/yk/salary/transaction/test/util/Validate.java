package com.hz.yk.salary.transaction.test.util;

import com.hz.yk.salary.pay.Paycheck;
import com.hz.yk.salary.pay.PaydayTransaction;

import java.util.Calendar;

public class Validate {

    public void validatePaycheck(PaydayTransaction pt, int empid, Calendar payDate, double pay) {
        Paycheck pc = pt.getPayCheck(empid);
        assert (pc != null);
        assert (pc.getPayPeriodEndDate() == payDate);
        //		assert("Hold".equals(pc.getField("Disposition")));
        assert (0.0 == pc.getDeductions());
        assert (pc.getNetPay() == pay);

    }
}
