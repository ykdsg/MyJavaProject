package com.hz.yk.orthogonal.v3;

import com.google.common.collect.Lists;
import com.hz.yk.orthogonal.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.hz.yk.orthogonal.v3.API.find;
import static com.hz.yk.orthogonal.v3.Matcher.ne;
import static com.hz.yk.orthogonal.v3.StudentPredicates.age;
import static com.hz.yk.orthogonal.v3.StudentPredicates.female;
import static com.hz.yk.orthogonal.v3.StudentPredicates.nameEq;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * @author wuzheng.yk
 * @date 2018/6/1
 */
public class TestAPI {

    List<Student> students = Lists.newArrayList();

    @BeforeAll
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
        students.add(new Student(20, "20name", 0));
    }

    @Test
    public void testFind() {

        //查找年龄不等于10岁的学生，可以如此描述
        assertThat(find(students, age(ne(10))).get(), notNullValue());

        //查找年龄不等于18岁的女生，可以表述为：
        assertThat(find(students, age(ne(18)).and(female())).get(), notNullValue());

        //查找年龄不等于18岁的或者是男生的而且名字是20name 的学生
        Student femalNameAge = find(students, age(ne(18)).or(Student::male).and(nameEq("20name"))).get();
        assertThat(femalNameAge, notNullValue());
    }
}
