package com.hz.yk.orthogonal;

/**
 * @author wuzheng.yk
 * @date 2018/6/1
 */
public class Student {

    private int age;

    private String name;

    /**
     * 0 男，1女
     */
    private int sex;

    public boolean female() {
        return sex == 1;
    }

    public boolean male() {
        return sex == 0;
    }

    public Student(int age, String name, int sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
        this.sex = 1;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
