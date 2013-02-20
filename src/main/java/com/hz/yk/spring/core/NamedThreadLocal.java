package com.hz.yk.spring.core;

import org.springframework.util.Assert;

/**
 * @author wuzheng.yk
 *         Date: 13-2-9
 *         Time: обнГ1:15
 */
public class NamedThreadLocal extends ThreadLocal{
    private final String name;


    /**
     * Create a new NamedThreadLocal with the given name.
     * @param name a descriptive name for this ThreadLocal
     */
    public NamedThreadLocal(String name) {
        Assert.hasText(name, "Name must not be empty");
        this.name = name;
    }

    public String toString() {
        return this.name;
    }



}
