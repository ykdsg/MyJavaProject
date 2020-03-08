package com.hz.yk.my.spring.source.core;

import org.springframework.util.Assert;

/**
 * @author wuzheng.yk
 * Date: 13-2-9
 * Time: ����1:15
 */
public class NamedThreadLocal extends ThreadLocal {

    private final String name;

    /**
     * Create a new NamedThreadLocal with the given name.
     *
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
