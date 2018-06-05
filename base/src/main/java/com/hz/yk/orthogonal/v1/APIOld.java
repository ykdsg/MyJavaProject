package com.hz.yk.orthogonal.v1;

import com.hz.yk.orthogonal.Student;

/**
 * 最原始的版本
 *
 * @author wuzheng.yk
 * @date 2018/6/5
 */
public class APIOld {

    /**
     * 缺乏弹性参数类型：只支持数组类型，List, Set都被拒之门外；
     * 容易出错：操作数组下标，往往引入不经意的错误；
     * 幻数：硬编码，将算法与配置高度耦合；
     *
     * @param students
     * @return
     */
    public static Student findByAge(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getAge() == 18) {
                return students[i];
            }
        }
        return null;
    }

}
