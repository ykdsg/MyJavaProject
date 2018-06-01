package com.hz.yk.orthogonal.v2;

import com.hz.yk.orthogonal.Student;

/**
 * @author wuzheng.yk
 * @date 2018/6/1
 */
public final class StudentPredicates {

    private StudentPredicates() {
    }

    public static Predicate<Student> ageEq(int age) {
        return s -> s.getAge() == age;
    }

    public static Predicate<Student> nameEq(String name) {
        return s -> s.getName().equals(name);
    }
}
