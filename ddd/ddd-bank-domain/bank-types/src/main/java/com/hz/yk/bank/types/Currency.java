package com.hz.yk.bank.types;

/**
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public class Currency {

    private String value;

    public Currency(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("货币不能为空");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Currency{" + "value='" + value + '\'' + '}';
    }
}
