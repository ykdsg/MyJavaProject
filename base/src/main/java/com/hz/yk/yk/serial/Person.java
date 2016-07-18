package com.hz.yk.yk.serial;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * .
 *
 * @author wuzheng.yk
 * @since 16/7/18
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name = null;
    private Integer age = null;
    private String mix = null;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMix() {
        return mix;
    }

    public void setMix(String mix) {
        this.mix = mix;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}
