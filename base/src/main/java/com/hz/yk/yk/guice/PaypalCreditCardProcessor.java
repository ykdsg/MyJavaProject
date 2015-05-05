package com.hz.yk.yk.guice;

/**
 * @author wuzheng.yk
 *         Date: 15/5/1
 *         Time: 23:12
 */
public class PaypalCreditCardProcessor implements CreditCardProcessor{
    @Override
    public void process() {
        System.out.println("paypal process;");
    }
}
