package com.hz.yk.orthogonal.v2;

import com.google.common.collect.Lists;
import com.hz.yk.orthogonal.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.hz.yk.orthogonal.v2.API.find;
import static com.hz.yk.orthogonal.v2.StudentPredicates.ageEq;
import static com.hz.yk.orthogonal.v2.StudentPredicates.nameEq;
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
    }

    @Test
    public void testFind() {

        //可以使用闭包的方式，解决结构性复杂的重复
        assertThat(find(students, s -> s.getAge() == 10), notNullValue());
        assertThat(find(students, s -> s.getName().equals("9name")), notNullValue());
        assertThat(find(students, s -> s.getName().equals("7name")), notNullValue());

        // 复用lambda,观察上面的测试用例，如果做到极致，可认为两个lambda表达式也是重复的。从「分离变化的方向」的角度分析，此lambda表达式承载的「比较算法」与「参数配置」两个职责，应该对其进行分离。
        assertThat(find(students, nameEq("9name")), notNullValue());
        assertThat(find(students, ageEq(10)), notNullValue());

    }
}
