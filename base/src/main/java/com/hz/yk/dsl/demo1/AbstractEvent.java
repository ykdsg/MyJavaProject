package com.hz.yk.dsl.demo1;

/**
 * 事件类和命令类，都有名称和编码
 * @author wuzheng.yk
 * @date 2021/4/17
 */
public class AbstractEvent {

    private String name, code;

    public AbstractEvent(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
