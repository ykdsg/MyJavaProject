package com.hz.yk.tdd.exception;

/**
 * @author wuzheng.yk
 * @date 2023/6/6
 */
public class IllegalOptionException extends RuntimeException{

    private String parameter;
    private static final long serialVersionUID = -6798538892143408726L;

    public IllegalOptionException(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}

