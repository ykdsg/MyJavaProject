package com.hz.yk.orthogonal.v1;

import com.hz.yk.orthogonal.Student;

/**
 * @author wuzheng.yk
 * @date 2018/6/1
 */
public class NamePredicate implements StudentPredicate {

    private String name;

    public NamePredicate(String name) {
        this.name = name;
    }

    @Override
    public boolean test(Student s) {
        return s.getName().equals(name);
    }
}
