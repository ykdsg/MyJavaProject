package com.hz.yk.tdd.exception;

/**
 * @author wuzheng.yk
 * @date 2023/6/12
 */
public class InsufficientArgumentsException extends RuntimeException{

    private static final long serialVersionUID = -3949441496419423103L;
    private String option;

    public InsufficientArgumentsException(String option) {
        this.option = option;
    }
    
    public String getOption() {
        return option;
    }
}
