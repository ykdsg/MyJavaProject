package com.hz.yk.orthogonal.v1;

import com.hz.yk.orthogonal.Student;

/**
 * 将「查找算法」与「比较准则」这两个「变化方向」进行分离。
 *
 * @author wuzheng.yk
 * @date 2018/6/1
 */
public interface StudentPredicate {

    boolean test(Student s);

}
