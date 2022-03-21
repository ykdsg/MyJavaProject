package com.hz.yk.serial;

import java.io.Serializable;

/**
 * @author wuzheng.yk
 * @date 2022/3/21
 */
public class Parent implements Serializable {

    private static final long serialVersionUID = 7839380946991519212L;

    private String parentName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
