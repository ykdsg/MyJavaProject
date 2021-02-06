package com.hz.yk.bank.exception;

/**
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public class MoneyAmoutNotNullException extends IllegalArgumentException {

    public MoneyAmoutNotNullException(String message) {
        super(message);
    }
}
