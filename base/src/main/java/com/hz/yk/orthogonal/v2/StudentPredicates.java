package com.hz.yk.orthogonal.v2;

import com.hz.yk.orthogonal.Student;

/**
 * @author wuzheng.yk
 * @date 2018/6/1
 */
public final class StudentPredicates {

    private StudentPredicates() {
    }

    /**
     * 可以通过「Static Factory Method」生产lambda表达式，将比较算法封装起来
     *
     * @param age
     * @return
     */
    public static Predicate<Student> ageEq(int age) {
        return s -> s.getAge() == age;
    }

    public static Predicate<Student> nameEq(String name) {
        return s -> s.getName().equals(name);
    }
}
