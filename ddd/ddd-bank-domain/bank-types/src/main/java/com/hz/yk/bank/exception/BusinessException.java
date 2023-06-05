package com.hz.yk.bank.exception;

/**
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public class BusinessException extends Exception {

    private static final long serialVersionUID = 6657699492927271694L;

    public BusinessException(String message) {
        super(message);
    }

}
