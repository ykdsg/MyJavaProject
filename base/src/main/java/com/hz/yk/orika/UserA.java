package com.hz.yk.orika;

/**
 * Created by wuzheng.yk on 2017/12/21.
 */
public class UserA {
    private Long id;
    private String name;

    public UserA() {
    }

    public UserA(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "UserA{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }

}
