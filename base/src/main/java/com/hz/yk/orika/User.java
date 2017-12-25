package com.hz.yk.orika;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by wuzheng.yk on 2017/12/21.
 */
public class User {

    private Long        id;
    private String      name;
    private List<UserA> userAList;
    private List<UserA> userBList;


    public User() {

    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
        userAList = Lists.newArrayList(new UserA(11L, "333"), new UserA(1113L, "332434"));
        userBList = Lists.newArrayList(new UserA(21L, "323"), new UserA(1213L, "3fsdfds"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
