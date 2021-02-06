package com.hz.yk.bank.types;

/**
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public class AccountNumber {

    private String value;

    public AccountNumber(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("账号不能为空");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
