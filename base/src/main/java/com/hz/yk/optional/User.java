package com.hz.yk.optional;

import java.util.List;
import java.util.Optional;

/**
 * @author wuzheng.yk
 * @date 2019/11/5
 */
public class User {

    private String email;
    private String position;
    private List<String> demoList;

    public User(String email, String position) {
        this.email = email;
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Optional<List<String>> getDemoList() {
        return Optional.ofNullable(demoList);
    }

    public void setDemoList(List<String> demoList) {
        this.demoList = demoList;
    }
}
