package com.hz.yk.orthogonal.v1;

import com.hz.yk.orthogonal.Student;

/**
 * @author wuzheng.yk
 * @date 2018/6/1
 */
public class AgePredicate implements StudentPredicate {

    private int age;

    public AgePredicate(int age) {
        this.age = age;
    }

    @Override
    public boolean test(Student s) {
        return s.getAge() == age;
    }
}

