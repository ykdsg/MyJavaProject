package com.hz.yk.orthogonal.v3;

import com.hz.yk.orthogonal.Student;

/**
 * @author wuzheng.yk
 * @date 2018/6/1
 */
public final class StudentPredicates {

    private StudentPredicates() {
    }

    public static Predicate<Student> age(Matcher<Integer> m) {
        return s -> m.matches(s.getAge());
    }

    public static Predicate<Student> nameEq(String name) {
        return s -> s.getName().equals(name);
    }
}
