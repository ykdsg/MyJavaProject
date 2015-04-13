package com.hz.yk.yk.spring.beanwrapper;

/**
 * @author wuzheng.yk
 *         Date: 13-1-31
 *         Time: обнГ9:15
 */
public class Company {
    private String name;
    private Employee managingDirector;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManagingDirector() {
        return this.managingDirector;
    }

    public void setManagingDirector(Employee managingDirector) {
        this.managingDirector = managingDirector;
    }
}
