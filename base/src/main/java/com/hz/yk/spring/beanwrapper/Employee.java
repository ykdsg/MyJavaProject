package com.hz.yk.spring.beanwrapper;

/**
 * @author wuzheng.yk
 *         Date: 13-1-31
 *         Time: ����9:15
 */
public class Employee {
    private float salary;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void showSalary() {
        System.out.println(salary);
    }
}
