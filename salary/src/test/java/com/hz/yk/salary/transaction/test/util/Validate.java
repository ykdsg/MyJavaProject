package com.hz.yk.salary.transaction.test.util;

import com.hz.yk.salary.pay.Paycheck;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
 import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Validate {

    public void validatePaycheck(Paycheck pc, Calendar payDate, double pay) {
        assertNotNull(pc);
        assertEquals(payDate, pc.getPayPeriodEndDate());
        assertEquals(0.0, pc.getDeductions(), 0.1);
        assertEquals(pc.getNetPay(), pay, 0.01);

    }
}
