package com.hz.yk.orthogonal.v1;

import com.google.common.collect.Lists;
import com.hz.yk.orthogonal.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * @author wuzheng.yk
 * @date 2018/6/1
 */
public class TestAPI {

    List<Student> students = Lists.newArrayList();

    @Before
    public void setup() {
        students.add(new Student(1, "1name"));
        students.add(new Student(2, "2name"));
        students.add(new Student(3, "3name"));
        students.add(new Student(4, "4name"));
        students.add(new Student(5, "5name"));
        students.add(new Student(6, "6name"));
        students.add(new Student(7, "7name"));
        students.add(new Student(8, "8name"));
        students.add(new Student(9, "9name"));
        students.add(new Student(10, "10name"));
        students.add(new Student(11, "11name"));
        students.add(new Student(12, "12name"));
        students.add(new Student(13, "13name"));
    }

    @Test
    public void testFind() {
        assertThat(API.find(students, new AgePredicate(10)), notNullValue());
        assertThat(API.find(students, new NamePredicate("9name")), notNullValue());

        //可以使用闭包的方式，解决结构性复杂的重复
        assertThat(API.find(students, s -> s.getAge() == 10), notNullValue());
        assertThat(API.find(students, s -> s.getName().equals("9name")), notNullValue());
    }
}
