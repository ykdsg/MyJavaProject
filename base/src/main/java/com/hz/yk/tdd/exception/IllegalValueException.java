package com.hz.yk.tdd.exception;

/**
 * @author wuzheng.yk
 * @date 2023/6/13
 */
public class IllegalValueException extends RuntimeException{

    private static final long serialVersionUID = -1583720240506030598L;
    private String option;
    private String value;

    public IllegalValueException(String option, String value) {
        this.option = option;
        this.value = value;
    }

    public String getOption() {
        return option;
    }

    public String getValue() {
        return value;
    }
}
