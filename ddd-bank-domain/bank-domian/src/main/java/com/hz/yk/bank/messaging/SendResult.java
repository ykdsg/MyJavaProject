package com.hz.yk.bank.messaging;

/**
 * @author wuzheng.yk
 * @date 2021/2/18
 */
public class SendResult {

    private final boolean isSuccess;

    public SendResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public static SendResult success() {
        return new SendResult(true);
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
