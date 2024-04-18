package com.hz.yk.tdd.exception;

/**
 * @author wuzheng.yk
 * @date 2023/6/6
 */
public class TooManyArgumentsException extends RuntimeException{

    private static final long serialVersionUID = 2211236015913823996L;

    private final String option;

    public TooManyArgumentsException(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
